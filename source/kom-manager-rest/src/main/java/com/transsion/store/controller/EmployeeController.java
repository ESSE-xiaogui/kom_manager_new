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
package com.transsion.store.controller;

import com.rest.service.controller.AbstractController;
import com.transsion.store.bo.Employee;
import com.transsion.store.dto.EmpResponseDto;
import com.transsion.store.dto.EmpUserDto;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.EmployeeFacade;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path("employee")
public class EmployeeController extends AbstractController{

	@Autowired
	private EmployeeFacade employeeFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public EmpResponseDto getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return employeeFacade.getByPK(primaryKey);
	}

	/**
	* 分页查询记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/listPg")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pagination<Employee> listPgEmployee(RequestModel<Employee> requestModel) throws ServiceException
	{
		Pagination<Employee> pagination = new Pagination<Employee>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return employeeFacade.listPaginationByProperty(pagination, requestModel.getParams());
	}

	/**
	* 根据多条主键值删除记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/delete")
	@Consumes({MediaType.APPLICATION_JSON})
	public void delete(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		employeeFacade.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 根据查询条件查询员工
	 * @return
	 * @throws ServiceException
	 */
	@POST
	@Path("/listByProperty")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<EmpResponseDto> listByProperty(Employee employee) throws ServiceException
	{
		return employeeFacade.listByProperty(employee);	
	}
	
	/**
	 * 新增员工
	 * @return
	 * @throws ServiceException
	 */
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public EmpResponseDto saveEmp(Employee employee) throws ServiceException
	{
		String token = this.getAuthorization();
		return employeeFacade.saveEmp(token,employee);
	}
	
	/**
	 * 修改员工信息
	 * @return
	 * @throws ServiceException
	 */
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public EmpResponseDto updateEmp(Employee employee) throws ServiceException
	{
		String token = this.getAuthorization();
		return employeeFacade.updateEmp(token,employee);
	}
	
	/**
	 * 为员工分配账号
	 * @return
	 * @throws ServiceException
	 */
	@POST
	@Path("/createUser")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public EmpResponseDto createUser(EmpUserDto empUserDto) throws ServiceException{
		String token = this.getAuthorization();
		return employeeFacade.createUser(token,empUserDto);
	}
	
	/**
	 * 更换账号绑定员工
	 * @return
	 * @throws ServiceException
	 */
	@POST
	@Path("/editUser")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public EmpResponseDto editUser(EmpUserDto empUserDto) throws ServiceException{
		String token = this.getAuthorization();
		return employeeFacade.editUser(token,empUserDto);
	}
	
	/**
	 * 模糊查询员工姓名
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getEmpInfo")
	@Produces({MediaType.APPLICATION_JSON})
	public List<EmpResponseDto> getEmpInfo(@QueryParam("empName") java.lang.String empName) throws ServiceException
	{
		return employeeFacade.getEmpInfo(empName);
	}
	
}
