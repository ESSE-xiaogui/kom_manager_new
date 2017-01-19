/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 17:33:07
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

import com.transsion.store.bo.Employee;
import com.transsion.store.dto.EmpInfoDto;
import com.transsion.store.dto.EmpResponseDto;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;

import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper extends GenericIBatisMapper<Employee, java.lang.Long> {

    public List<EmpInfoDto> listPaginationByProperty(Pagination<EmpInfoDto> pagination, @Param("empInfoDto")EmpInfoDto empInfoDto, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;

	public List<EmpResponseDto> getEmpInfo(String empName)throws DataAccessFailureException;

	public List<EmpResponseDto> listByProp(Employee employee) throws DataAccessFailureException;
	
	public int updateIsHistory(Long primaryKey) throws DataAccessFailureException;
	
	public void updateIsHistorys(@Param("primaryKeys") List<Long> primaryKeys) throws DataAccessFailureException;

}
