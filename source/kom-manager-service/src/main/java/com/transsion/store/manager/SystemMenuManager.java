package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.SystemMenu;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.MenuDto;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.service.SystemMenuService;
import com.transsion.store.utils.CacheUtils;


@Service("systemMenuManager")
public class SystemMenuManager {
	@Autowired
	private SystemMenuService systemMenuService;
	
	/**
	* 树形显示所有带权限菜单
	* @return
	* @throws ServiceException
	*/
	public List<MenuDto> findMenuList(String token) throws ServiceException {
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		Integer userId = userContext.getUser().getUserId();
		List<MenuDto> list = systemMenuService.querySystemMenuList(userId); 
		return treeMenuList(list,Long.valueOf(0));
	}
	
	/**
	* 树形显示所有不带权限菜单
	* @return
	* @throws ServiceException
	*/
	public List<MenuDto> findAllMenu() throws ServiceException{
		List<MenuDto> list = systemMenuService.queryAllMenuList();
		return treeMenuList(list,Long.valueOf(0));
	}
	
	public List<MenuDto> treeMenuList(List<MenuDto> list, Long parentId) {  
		List<MenuDto> childMenu = new ArrayList<MenuDto>();  
	       for (MenuDto menuDto : list) {   
	    	   Long menuId = menuDto.getMenuId();  
	    	   Long pid = menuDto.getParentMenuId();
	           if (parentId == pid) {  
	        	   List<MenuDto> children = treeMenuList(list, menuId);  
	        	   menuDto.setChildren(children);
	        	   childMenu.add(menuDto);
	           }  
	       }  	    
	       return childMenu;  
	}

	
	
	/**
	* 级联删除菜单
	* @return
	* @throws ServiceException
	*/
	public void deleteByMenuId(List<java.lang.Long> menuIdList) throws ServiceException {
		Long menuId = menuIdList.get(0);
		List<java.lang.Long> result = new ArrayList<java.lang.Long>();
		List<java.lang.Long> listMenuId = treeList(menuId,result);
		listMenuId.add(menuId);
		systemMenuService.deleteByPKeys(listMenuId);
	}  
	
	public List<java.lang.Long> treeList(Long menuId,List<java.lang.Long> result)throws ServiceException{
		List<java.lang.Long> menuIds = systemMenuService.queryMenuIdList(menuId);
		result.addAll(menuIds);
		if(!menuIds.isEmpty()){
			for(Long mid:menuIds){
				treeList(mid,result);
			}
		}
		return result;
	}
	
	/**
	* 查询菜单及其父菜单名称
	* @return
	* @throws ServiceException
	*/
	public MenuDto getOneMenu(java.lang.Long menuId) throws ServiceException{
		 MenuDto menuDto = systemMenuService.findMenuByMenuId(menuId);
		 Long pid = menuDto.getParentMenuId();
		 if(pid!=0){
			 StringBuffer sb = new StringBuffer();
			 while(pid!=0){
				 MenuDto md = systemMenuService.findMenuByMenuId(pid);
				 sb.insert(0,"/"+md.getMenuName());
				 pid=md.getParentMenuId();
			 }
			 menuDto.setParentMenuName(sb.substring(1,sb.length()));
		 }else{
			 menuDto.setParentMenuName("");
		 }
		 return menuDto;
	}
	
	/**
	* 增加菜单时验证menuCode
	* @return
	* @throws ServiceException
	*/
	public void save(SystemMenu systemMenu) throws ServiceException {
		List<SystemMenu> list = systemMenuService.findByMenuCode(systemMenu.getMenuCode());
		if(!UtilHelper.isEmpty(list)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_MENUCODE_IS_DUPLICATE);
		}else{
			systemMenuService.save(systemMenu);
		}
	}

	/**
	* 编辑菜单时验证menuCode
	* @return
	* @throws ServiceException
	*/
	public int update(SystemMenu systemMenu) throws ServiceException {
		List<SystemMenu> list = systemMenuService.findByMenuCode(systemMenu.getMenuCode());
		if(!UtilHelper.isEmpty(list)){
			if(!systemMenu.getMenuId().equals(list.get(0).getMenuId())){
				throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_MENUCODE_IS_DUPLICATE);			
			}
		}
		return systemMenuService.update(systemMenu);
	}
}
