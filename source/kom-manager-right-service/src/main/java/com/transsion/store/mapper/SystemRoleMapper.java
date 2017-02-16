/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 17:33:13
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

import javax.ws.rs.QueryParam;

import com.transsion.store.bo.SystemRole;
import com.transsion.store.dto.SystemRoleResponseDto;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import org.apache.ibatis.annotations.Param;

public interface SystemRoleMapper extends GenericIBatisMapper<SystemRole, java.lang.Long> {

    public List<SystemRole> listPaginationByProperty(Pagination<SystemRole> pagination, @Param("systemRole")SystemRole systemRole, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
    public List<SystemRoleResponseDto> findSystemRoleByUser(@Param("userId")Integer userId) throws DataAccessFailureException;
    public List<SystemRoleResponseDto> findSystemRole() throws DataAccessFailureException;
    public SystemRoleResponseDto updateRoleStatus(@Param("userId")Integer userId,@Param("roleId")Long roleId,@QueryParam("isInactive") java.lang.Integer isInactive)throws DataAccessFailureException;
	public List<SystemRoleResponseDto> findRole(SystemRole systemRole)throws DataAccessFailureException;
	public List<String> findRoleCode(@Param("userId")Integer userId) throws DataAccessFailureException;
}
