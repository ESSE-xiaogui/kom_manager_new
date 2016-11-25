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
package com.transsion.store.mapper;

import java.util.List;
import java.util.Map;

import com.transsion.store.bo.SystemMenu;
import com.transsion.store.dto.MenuDto;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import org.apache.ibatis.annotations.Param;

public interface SystemMenuMapper extends GenericIBatisMapper<SystemMenu, java.lang.Long> {

    public List<SystemMenu> listPaginationByProperty(Pagination<SystemMenu> pagination, @Param("systemMenu")SystemMenu systemMenu, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
    
    public List<MenuDto> querySystemMenuList(Integer userId) throws DataAccessFailureException;

	public List<SystemMenu> listByParentId(Long parentMenuId) throws DataAccessFailureException;

	public List<MenuDto> queryAllMenuList() throws DataAccessFailureException;

	public List<java.lang.Long> queryMenuIdList(Long menuId) throws DataAccessFailureException;

	public MenuDto findMenuByMenuId(Long menuId) throws DataAccessFailureException;

}
