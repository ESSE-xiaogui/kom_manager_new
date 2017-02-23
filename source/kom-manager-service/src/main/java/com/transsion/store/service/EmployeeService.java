/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2016-11-18 15:56:35
*
* Amendment History:
*
* Amended By       Amended On      Amendment Description
* ------------     -----------     ---------------------------------------------
*
**/
package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transsion.store.bo.Employee;
import com.transsion.store.dto.EmpInfoDto;
import com.transsion.store.dto.EmpResponseDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.mapper.EmployeeMapper;

@Service("employeeService")
public class EmployeeService {

	private EmployeeMapper	employeeMapper;

	@Autowired
	public void setEmployeeMapper(EmployeeMapper employeeMapper)
	{
		this.employeeMapper = employeeMapper;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Employee getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return employeeMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Employee> list() throws ServiceException
	{
		return employeeMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<EmpResponseDto> listByProperty(Employee employee)
			throws ServiceException
	{
		return employeeMapper.listByProp(employee);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<EmpInfoDto> listPaginationByProperty(Pagination<EmpInfoDto> pagination, EmpInfoDto empInfoDto)
			throws ServiceException
	{
		List<EmpInfoDto> list = employeeMapper.listPaginationByProperty(pagination, empInfoDto, pagination.getOrderBy());
		pagination.setResultList(list);
		
		return pagination;
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return employeeMapper.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		
		employeeMapper.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param employee
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Employee employee) throws ServiceException
	{
		return employeeMapper.deleteByProperty(employee);
	}

	/**
	 * 保存记录
	 * @param employee
	 * @return
	 * @throws ServiceException
	 */
	public void save(Employee employee) throws ServiceException
	{
		employeeMapper.save(employee);
	}

	/**
	 * 更新记录
	 * @param employee
	 * @return
	 * @throws ServiceException
	 */
	public int update(Employee employee) throws ServiceException
	{
		return employeeMapper.update(employee);
	}

	/**
	 * 根据条件查询记录条数
	 * @param employee
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Employee employee) throws ServiceException
	{
		return employeeMapper.findByCount(employee);
	}

	/**
	 * 模糊查询员工姓名
	 * @return
	 * @throws ServiceException
	 */
	public List<EmpResponseDto> getEmpInfo(String empName) throws ServiceException{
		return employeeMapper.getEmpInfo(empName);
	}
}