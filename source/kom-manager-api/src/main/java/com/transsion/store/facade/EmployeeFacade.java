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
package com.transsion.store.facade;

import java.util.List;

import com.transsion.store.bo.Employee;
import com.transsion.store.dto.EmpResponseDto;
import com.transsion.store.dto.EmpUserDto;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;

public interface EmployeeFacade {

	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public EmpResponseDto getByPK(java.lang.Long primaryKey) throws ServiceException;

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Employee> list() throws ServiceException;

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<EmpResponseDto> listByProperty(Employee employee)
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
	 * @param employee
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Employee employee) throws ServiceException;

	/**
	 * 保存记录
	 * @param employee
	 * @return
	 * @throws ServiceException
	 */
	public void save(Employee employee) throws ServiceException;

	/**
	 * 更新记录
	 * @param employee
	 * @return
	 * @throws ServiceException
	 */
	public int update(Employee employee) throws ServiceException;

	/**
	 * 根据条件查询记录条数
	 * @param employee
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Employee employee) throws ServiceException;
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Employee> listPaginationByProperty(Pagination<Employee> pagination, Employee employee)
			throws ServiceException;

	/**
	 * 新增员工
	 * @return
	 * @throws ServiceException
	 */
	public EmpResponseDto saveEmp(String token,Employee employee) throws ServiceException;

	/**
	 * 修改员工信息
	 * @return
	 * @throws ServiceException
	 */
	public EmpResponseDto updateEmp(String token, Employee employee) throws ServiceException;

	/**
	 * 为员工分配账号
	 * @return
	 * @throws ServiceException
	 */
	public EmpResponseDto createUser(String token, EmpUserDto empUserDto) throws ServiceException;

	/**
	 * 更换账号绑定员工
	 * @return
	 * @throws ServiceException
	 */
	public EmpResponseDto editUser(String token, EmpUserDto empUserDto) throws ServiceException;

	/**
	 *  模糊查询员工姓名
	 * @return
	 * @throws ServiceException
	 */
	public List<EmpResponseDto> getEmpInfo(String empName) throws ServiceException;

}
