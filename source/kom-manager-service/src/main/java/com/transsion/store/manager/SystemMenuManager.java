package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.SystemMenu;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.MenuDto;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.service.SystemMenuService;
import com.transsion.store.utils.CacheUtils;


@Service("systemMenuManager")
public class SystemMenuManager {
	@Autowired
	private SystemMenuService systemMenuService;
	
	@Autowired
	private SystemDateService systemDateService;
	
	/**
	* 树形显示所有带权限菜单
	* @return
	* @throws ServiceException
	*/
	public List<MenuDto> findMenuList(String token) throws ServiceException {
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		Integer userId = userContext.getUser().getUserId();
		List<MenuDto> list = systemMenuService.querySystemMenuList(userId); 
		return treeMenuList(list,0l);
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
		for(int i=0;i<menuIdList.size();i++){
			Long menuId = menuIdList.get(i);
			List<java.lang.Long> result = new ArrayList<java.lang.Long>();
			List<java.lang.Long> listMenuId = treeList(menuId,result);
			listMenuId.add(menuId);
			systemMenuService.deleteByPKeys(listMenuId);
		}
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
		 if(0!=pid){
			 StringBuffer sb = new StringBuffer();
			 while(0!=pid){
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
	public void save(String token,SystemMenu systemMenu) throws ServiceException {
		SystemMenu tempMenu = new SystemMenu();
		tempMenu.setMenuCode(systemMenu.getMenuCode());
		int count = systemMenuService.findByCount(tempMenu);
		if(count>0){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_MENUCODE_IS_DUPLICATE);
		}else{
			UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
			systemMenu.setCreatedBy(userContext.getUser().getUserCode());
			systemMenu.setCreateTime(systemDateService.getCurrentDate());
			systemMenuService.save(systemMenu);
		}
	}

	/**
	* 编辑菜单时验证menuCode
	* @return
	* @throws ServiceException
	*/
	public int update(String token,SystemMenu systemMenu) throws ServiceException {
		SystemMenu tempMenu = new SystemMenu();
		tempMenu.setMenuCode(systemMenu.getMenuCode());
		int count1 = systemMenuService.findByCount(tempMenu);
		tempMenu.setMenuId(systemMenu.getMenuId());
		int count2 = systemMenuService.findByCount(tempMenu);
		if(count1>0 && count2<1){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_MENUCODE_IS_DUPLICATE);			
		}
		SystemMenu formerMenu = systemMenuService.getByPK(systemMenu.getMenuId());
		formerMenu.setMenuCode(systemMenu.getMenuCode());
		formerMenu.setMenuName(systemMenu.getMenuName());
		formerMenu.setMenuIcon(systemMenu.getMenuIcon());
		formerMenu.setPageUrl(systemMenu.getPageUrl());
		formerMenu.setRemark(systemMenu.getRemark());
		formerMenu.setMenuOrder(systemMenu.getMenuOrder());
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		formerMenu.setUpdatedBy(userContext.getUser().getUserCode());
		formerMenu.setUpdateTime(systemDateService.getCurrentDate());
		return systemMenuService.update(formerMenu);
	}

	
	/**
	* 根据roleId查询菜单
	* @return
	* @throws ServiceException
	*/
	public List<MenuDto> findMenuByRoleId(Long roleId) throws ServiceException{
		List<MenuDto> list = systemMenuService.findMenuByRoleId(roleId);
		return treeMenuList(list,Long.valueOf(0));
	}
}
