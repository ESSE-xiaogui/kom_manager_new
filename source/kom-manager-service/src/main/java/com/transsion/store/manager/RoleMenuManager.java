package com.transsion.store.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.RoleMenu;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.RoleMenuDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.RoleMenuMapper;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("roleMenuManager")
public class RoleMenuManager {
	@Autowired
	private RoleMenuMapper roleMenuMapper;

	@Autowired
	private SystemDateService systemDateService;

	public void saveMenuRole(String token, RoleMenuDto roleMenuDto) throws ServiceException {
		if (UtilHelper.isEmpty(token)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if (UtilHelper.isEmpty(userContext.getUser())) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		RoleMenu roleMenu = new RoleMenu();
		Long roleId = roleMenuDto.getRoleId();
		roleMenu.setRoleId(roleId);
		roleMenuMapper.deleteByProperty(roleMenu);
		List<Long> menuList = roleMenuDto.getMenus();
		if (!UtilHelper.isEmpty(menuList)) {
			for (Long menuId : menuList) {
				RoleMenu rm = new RoleMenu();
				rm.setRoleId(roleId);
				rm.setMenuId(menuId);
				rm.setCreatedBy(userContext.getUser().getUserCode());
				rm.setCreateTime(systemDateService.getCurrentDate());
				roleMenuMapper.save(rm);
			}
		}
	}
}
