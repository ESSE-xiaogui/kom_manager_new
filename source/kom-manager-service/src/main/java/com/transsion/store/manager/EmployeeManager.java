package com.transsion.store.manager;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Duty;
import com.transsion.store.bo.Employee;
import com.transsion.store.bo.User;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.EmpResponseDto;
import com.transsion.store.dto.EmpUserDto;
import com.transsion.store.dto.OrganizationDto;
import com.transsion.store.dto.UserDto;
import com.transsion.store.mapper.DutyMapper;
import com.transsion.store.mapper.EmployeeMapper;
import com.transsion.store.mapper.OrganizationMapper;
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
	private EmployeeMapper employeeMapper;
	
	@Autowired
	private SystemDateService systemDateService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrganizationMapper organizationMapper;
	
	@Autowired
	private DutyMapper dutyMapper;
	
	private static final String PASSWORD = "123456";
	
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
		/*Employee tempEmp = new Employee();
		tempEmp.setEmpCode(employee.getEmpCode());
		int count = employeeService.findByCount(tempEmp);
		if(count>0){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_EMPCODE_IS_DUPLICATE);
		}*/
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
	/*	Employee tempEmp = new Employee();
		tempEmp.setEmpCode(employee.getEmpCode());
		int count1 = employeeService.findByCount(tempEmp);
		tempEmp.setId(employee.getId());
		int count2 = employeeService.findByCount(tempEmp);
		if(count1>0 && count2<1){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_EMPCODE_IS_DUPLICATE);
		}*/
		Employee formerEmp = employeeMapper.getByPK(employee.getId());
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
		formerEmp.setUpperCode(employee.getUpperCode());
		formerEmp.setInService(employee.getInService());

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
		if(UtilHelper.isEmpty(empUserDto.getUserCode())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USERCODE_IS_NULL);
		}
		if(UtilHelper.isEmpty(empUserDto.getPassword())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PASSWORD_IS_NULL);
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
		user.setPassword(MD5Utils.encrypt(PASSWORD));
		user.setIsInactive(1);
		user.setCreatedBy(userContext.getUser().getUserCode());
		user.setCreatedTime(systemDateService.getCurrentDate());
		userService.save(user);
		Employee employee = employeeMapper.getByPK(empUserDto.getId());
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
		if(UtilHelper.isEmpty(empUserDto.getUserCode())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USERCODE_IS_NULL);
		}
		String userCode = empUserDto.getUserCode();
		UserDto userDto = userService.findByName(userCode);
		if(UtilHelper.isEmpty(userDto)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_IS_NULL);
		}
		Long empId = empUserDto.getId();
		
		Employee employee = employeeMapper.getByPK(empId);
		if(UtilHelper.isEmpty(employee)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_EMP_DOESNOT_EXIST);
		}
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

	/**
	 * 通过主键获取员工信息
	 * @return
	 * @throws ServiceException
	 */
	public EmpResponseDto getByPKey(Long primaryKey) throws ServiceException {
		if(UtilHelper.isEmpty(primaryKey)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		Employee emp = employeeService.getByPK(primaryKey);
		EmpResponseDto erd = new EmpResponseDto();
		BeanUtils.copyProperties(emp, erd);
		OrganizationDto org = organizationMapper.getByPKs(Long.valueOf(erd.getOrgId()));
		if(!UtilHelper.isEmpty(org)){
			erd.setOrgName(org.getOrgName());
		}
		Duty duty = dutyMapper.getByPK(Long.valueOf(erd.getOrgId()));
		if(!UtilHelper.isEmpty(duty)){
			erd.setDutyName(duty.getDutyName());
		}
		return erd;
	}

	/**
	 * 根据查询条件查询员工
	 * @return
	 * @throws ServiceException
	 */
	public List<EmpResponseDto> listByProperty(Employee employee) throws ServiceException {
		List<EmpResponseDto> erdList = employeeMapper.listByProp(employee);
		if(UtilHelper.isEmpty(erdList)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_EMP_DOESNOT_EXIST);
		}
		return erdList;
	}

}
