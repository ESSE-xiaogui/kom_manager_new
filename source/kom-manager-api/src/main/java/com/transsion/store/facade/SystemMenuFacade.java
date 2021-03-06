/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2016-10-31 14:25:26
*
* Amendment History:
*
* Amended By       Amended On      Amendment Description
* ------------     -----------     ---------------------------------------------
*
**/
package com.transsion.store.facade;

import java.util.List;
import com.transsion.store.bo.SystemMenu;
import com.transsion.store.dto.MenuDto;
import com.transsion.store.dto.SystemMenuInfo;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;

public interface SystemMenuFacade {

	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public SystemMenu getByPK(java.lang.Long primaryKey) throws ServiceException;

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<SystemMenu> list() throws ServiceException;

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<SystemMenu> listByProperty(SystemMenu systemMenu)
			throws ServiceException;

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException;
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException;

	/**
	 * 根据传入参数删除记录
	 * @param systemMenu
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(SystemMenu systemMenu) throws ServiceException;

	/**
	 * 保存记录
	 * @param systemMenu
	 * @return
	 * @throws ServiceException
	 */
	public void save(String token,SystemMenu systemMenu) throws ServiceException;

	/**
	 * 更新记录
	 * @param systemMenu
	 * @return
	 * @throws ServiceException
	 */
	public int update(String token,SystemMenu systemMenu) throws ServiceException;

	/**
	 * 根据条件查询记录条数
	 * @param systemMenu
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(SystemMenu systemMenu) throws ServiceException;
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<SystemMenuInfo> listPaginationByProperty(Pagination<SystemMenuInfo> pagination, SystemMenuInfo systemMenuInfo)
			throws ServiceException;
	
	/**
	 * 获取菜单
	 * @return
	 * @throws ServiceException
	 */
	public List<MenuDto> findMenuList(String token) throws ServiceException;
	
	/**
	* 根据条件查询菜单
	* @return
	* @throws ServiceException
	*/
	public List<SystemMenu> listByParentId(java.lang.Long parentMenuId) throws ServiceException;

	/**
	* 获取所有不带权限菜单
	* @return
	* @throws ServiceException
	*/
	public List<MenuDto> findAllMenu() throws ServiceException;

	/**
	* 级联删除菜单
	* @return
	* @throws ServiceException
	*/
	public void deleteByMenuId(List<java.lang.Long> menuIdList) throws ServiceException;

	/**
	* 查询菜单及其父菜单名称
	* @return
	* @throws ServiceException
	*/
	public MenuDto getOneMenu(Long menuId) throws ServiceException;

	/**
	* 根据roleId查询树形菜单
	* @return
	* @throws ServiceException 
	*/
	public List<MenuDto> findMenuByRoleId(Long roleId) throws ServiceException;
	
}
