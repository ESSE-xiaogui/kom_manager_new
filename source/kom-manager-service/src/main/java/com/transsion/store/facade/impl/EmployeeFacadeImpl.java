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
package com.transsion.store.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transsion.store.bo.Employee;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.facade.EmployeeFacade;
import com.transsion.store.service.EmployeeService;

@Component("employeeFacade")
public class EmployeeFacadeImpl implements EmployeeFacade {

	private EmployeeService employeeService;
	
	@Autowired
	public void setEmployeeService(EmployeeService employeeService)
	{
		this.employeeService = employeeService;
	}
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Employee getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return employeeService.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Employee> list() throws ServiceException
	{
		return employeeService.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Employee> listByProperty(Employee employee)
			throws ServiceException
	{
		return employeeService.listByProperty(employee);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Employee> listPaginationByProperty(Pagination<Employee> pagination, Employee employee)
			throws ServiceException
	{
		return employeeService.listPaginationByProperty(pagination, employee);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return employeeService.deleteByPK(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		employeeService.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据传入参数删除记录
	 * @param employee
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Employee employee) throws ServiceException
	{
		return employeeService.deleteByProperty(employee);
	}

	/**
	 * 保存记录
	 * @param employee
	 * @return
	 * @throws ServiceException
	 */
	public void save(Employee employee) throws ServiceException
	{
		employeeService.save(employee);
	}

	/**
	 * 更新记录
	 * @param employee
	 * @return
	 * @throws ServiceException
	 */
	public int update(Employee employee) throws ServiceException
	{
		return employeeService.update(employee);
	}

	/**
	 * 根据条件查询记录条数
	 * @param employee
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Employee employee) throws ServiceException
	{
		return employeeService.findByCount(employee);
	}
}
