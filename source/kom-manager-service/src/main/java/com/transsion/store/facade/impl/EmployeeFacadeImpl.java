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

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Employee;
import com.transsion.store.dto.EmpInfoDto;
import com.transsion.store.dto.EmpResponseDto;
import com.transsion.store.dto.EmpUserDto;
import com.transsion.store.facade.EmployeeFacade;
import com.transsion.store.manager.EmployeeManager;
import com.transsion.store.service.EmployeeService;

@Component("employeeFacade")
public class EmployeeFacadeImpl implements EmployeeFacade {

	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeManager employeeManager;
	
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
	public EmpResponseDto getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return employeeManager.getByPKey(primaryKey);
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
	public List<EmpResponseDto> listByProperty(Employee employee)throws ServiceException
	{
		return employeeManager.listByProperty(employee);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<EmpInfoDto> listPaginationByProperty(Pagination<EmpInfoDto> pagination, EmpInfoDto empInfoDto)
			throws ServiceException
	{
		return employeeService.listPaginationByProperty(pagination, empInfoDto);
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return employeeManager.updateIsHistory(primaryKey);
	}
	
	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		employeeManager.updateIsHistorys(primaryKeys);
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
	
	/**
	 * 新增员工
	 * @return
	 * @throws ServiceException
	 */
	public EmpResponseDto saveEmp(String token,Employee employee) throws ServiceException
	{
		return employeeManager.saveEmp(token,employee);
	}
	
	/**
	 * 修改员工信息
	 * @return
	 * @throws ServiceException
	 */
	public void updateEmp(String token,Employee employee) throws ServiceException
	{
		employeeManager.updateEmp(token,employee);
	}
	
	/**
	 * 为员工分配账号
	 * @return
	 * @throws ServiceException
	 */
	public void createUser(String token,EmpUserDto empUserDto) throws ServiceException{
		employeeManager.createUser(token,empUserDto);
	}
	
	/**
	 * 更换账号绑定员工
	 * @return
	 * @throws ServiceException
	 */
	public void editUser(String token,EmpUserDto empUserDto) throws ServiceException{
		employeeManager.editUser(token,empUserDto);
	}
	
	/**
	 * 模糊查询员工姓名
	 * @return
	 * @throws ServiceException
	 */
	public List<EmpResponseDto> getEmpInfo(java.lang.String empName) throws ServiceException
	{
		return employeeService.getEmpInfo(empName);
	}
}
