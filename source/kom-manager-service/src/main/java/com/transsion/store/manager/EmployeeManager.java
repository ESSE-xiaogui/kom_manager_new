package com.transsion.store.manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.Base64;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Employee;
import com.transsion.store.bo.User;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.EmpResponseDto;
import com.transsion.store.dto.EmpUserDto;
import com.transsion.store.dto.UserDto;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.service.EmployeeService;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.service.UserService;
import com.transsion.store.utils.CacheUtils;
import com.transsion.store.utils.MD5Utils;

@Service("employeeManager")
public class EmployeeManager {
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private SystemDateService systemDateService;
	
	@Autowired
	private UserService userService;
	
	public EmpResponseDto saveEmp(String token,Employee employee) throws ServiceException
	{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		if(UtilHelper.isEmpty(employee)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_IS_NULL);
		}
		
		employee.setCreatedBy(userContext.getUser().getUserCode());
		employee.setCreatedTime(systemDateService.getCurrentDate());
		employee.setCompanyId(userContext.getUser().getCompanyId());
		employeeService.save(employee);
		EmpResponseDto emp = new EmpResponseDto();
		emp.setStatus(1);
		return emp;
	}
	
	/**
	 * 更新员工信息
	 * @return
	 * @throws ServiceException
	 */
	public EmpResponseDto updateEmp(String token,Employee employee) throws ServiceException
	{	
		Employee formerEmp = employeeService.getByPK(employee.getId());
		formerEmp.setEmpName(employee.getEmpName());
		formerEmp.setGender( employee.getGender());
		formerEmp.setNation(employee.getNation());
		formerEmp.setMarried(employee.getMarried());
		formerEmp.setIdNo(employee.getIdNo());
		formerEmp.setBirthday(employee.getBirthday());
		formerEmp.setOrgId(employee.getOrgId());
		formerEmp.setDutyId(employee.getDutyId());
		formerEmp.setPhoneNo(employee.getPhoneNo());
		formerEmp.setEmail(employee.getEmail());
		formerEmp.setUpperName(employee.getUpperName());
		formerEmp.setUpperId(employee.getUpperId());
		formerEmp.setInService(employee.getInService());
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		formerEmp.setUpdatedBy(userContext.getUser().getUserCode());
		formerEmp.setUpdatedTime(systemDateService.getCurrentDate());
		employeeService.update(formerEmp);
		EmpResponseDto emp = new EmpResponseDto();
		emp.setStatus(1);
		return emp;
	}
	
	/**
	 * 为员工分配账号
	 * @return
	 * @throws ServiceException
	 */
	public EmpResponseDto createUser(String token,EmpUserDto empUserDto) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}	
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_IS_NULL);
		}
		String userCode = empUserDto.getUserCode();
		User user = new User();
		user.setUserCode(userCode);
		if(userService.findByCount(user)>0){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_ALREADY_EXISTS);
		}
		Long uId = employeeService.getByPK(empUserDto.getId()).getuId();
		if(!UtilHelper.isEmpty(uId)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_EMP_ALREADY_DISTRIBUTED);
		}
		user.setCompanyId(userContext.getUser().getCompanyId());
		user.setPassword(MD5Utils.encrypt("123456"));
		user.setIsInactive(0);
		user.setCreatedBy(userContext.getUser().getUserCode());
		user.setCreatedTime(systemDateService.getCurrentDate());
		userService.save(user);
		Employee employee = employeeService.getByPK(empUserDto.getId());
		employee.setuId(userService.listByProperty(user).get(0).getId());
		employeeService.update(employee);
		
		EmpResponseDto erd = new EmpResponseDto();
		erd.setStatus(1);
		return erd;
	}
	
	/**
	 * 更换账号绑定员工
	 * @return
	 * @throws ServiceException
	 */
	public EmpResponseDto editUser(String token,EmpUserDto empUserDto) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}	
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_IS_NULL);
		}
		String userCode = empUserDto.getUserCode();
		UserDto userDto = userService.findByName(userCode);
		if(UtilHelper.isEmpty(userDto)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_IS_NULL);
		}
		Long empId = empUserDto.getId();
		
		Employee employee = employeeService.getByPK(empId);
		Long uId = employee.getuId();
		if(!UtilHelper.isEmpty(uId)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_EMP_ALREADY_DISTRIBUTED);
		}
		User user = new User();
		user.setUserCode(userCode);
		employee.setuId(userService.listByProperty(user).get(0).getId());
		employeeService.update(employee);
	
		EmpResponseDto erd = new EmpResponseDto();
		erd.setStatus(1);
		return erd;
		
	}
}
