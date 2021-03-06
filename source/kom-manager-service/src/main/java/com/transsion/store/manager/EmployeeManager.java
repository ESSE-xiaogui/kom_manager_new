package com.transsion.store.manager;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.ConstantUtil;
import com.transsion.store.bo.Duty;
import com.transsion.store.bo.Employee;
import com.transsion.store.bo.Organization;
import com.transsion.store.bo.User;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.EmpResponseDto;
import com.transsion.store.dto.EmpUserDto;
import com.transsion.store.dto.OrganizationDto;
import com.transsion.store.dto.UserDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.DutyMapper;
import com.transsion.store.mapper.EmployeeMapper;
import com.transsion.store.mapper.OrganizationMapper;
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
	
	private static final Integer IS_INACTIVE = 2;
	
	public EmpResponseDto saveEmp(String token,Employee employee) throws ServiceException
	{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(employee)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		/**
		 * 新建员工必须绑定组织机构,组织机构ID不能为空
		 * */
		if(UtilHelper.isEmpty(employee.getOrgId())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		Organization org = organizationMapper.getByPK(new Long(employee.getOrgId()));
		if(UtilHelper.isEmpty(org)){
			throw new ServiceException(ExceptionDef.ERROR_ORGANIZATION_ALREADY_EXIST.getName());
		}
		/**
		 * 组织机构停用 不能绑定员工
		 * */
		if(org.getIsInactive().equals(ConstantUtil.STATUS_TWO)){
			throw new ServiceException(ExceptionDef.ERROR_ORGANIZATION_INACTIVE.getName());
		}
		employee.setIsHistory(2);
		employee.setCreatedBy(userContext.getUserCode());
		employee.setCreatedTime(systemDateService.getCurrentDate());
		employee.setBirthday(employee.getBirthday().equals("")?null:employee.getBirthday());
		employee.setCompanyId(userContext.getUser().getCompanyId());
		employeeService.save(employee);
		EmpResponseDto emp = new EmpResponseDto();
		emp.setId(employee.getId());
		emp.setStatus(1);
		return emp;
	}
	
	/**
	 * 更新员工信息
	 * @return
	 * @throws ServiceException
	 */
	public void updateEmp(String token,Employee employee) throws ServiceException
	{	
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(employee)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}

		Employee formerEmp = employeeMapper.getByPK(employee.getId());
		formerEmp.setRegionId(employee.getRegionId());
		formerEmp.setEmpName(employee.getEmpName());
		formerEmp.setGender( employee.getGender());
		formerEmp.setNation(employee.getNation());
		formerEmp.setMarried(employee.getMarried());
		formerEmp.setIdNo(employee.getIdNo());
		formerEmp.setBirthday(employee.getBirthday().equals("")?null:employee.getBirthday());
		formerEmp.setOrgId(employee.getOrgId());
		formerEmp.setDutyId(employee.getDutyId());
		formerEmp.setMobileNo(employee.getMobileNo());
		formerEmp.setEmail(employee.getEmail());
		formerEmp.setUpperName(employee.getUpperName());
		formerEmp.setUpperId(employee.getUpperId());
		formerEmp.setInService(employee.getInService());
		formerEmp.setUpdatedBy(userContext.getUserCode());
		formerEmp.setUpdatedTime(systemDateService.getCurrentDate());
		employeeService.update(formerEmp);
	}
	
	/**
	 * 为员工分配账号
	 * @return
	 * @throws ServiceException
	 */
	public void createUser(String token,EmpUserDto empUserDto) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}	
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		Long empId = empUserDto.getId();
		String userCode = empUserDto.getUserCode();
		String password = empUserDto.getPassword();
		if(UtilHelper.isEmpty(empId)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		if(UtilHelper.isEmpty(userCode)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		if(UtilHelper.isEmpty(password)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		
		User user = new User();
		user.setUserCode(userCode);
		if(userService.findByCount(user)>0){
			throw new ServiceException(ExceptionDef.ERROR_USER_ALREADY_EXIST.getName());
		}
		Employee employee = employeeService.getByPK(empId);
		if(UtilHelper.isEmpty(employee)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		Integer inService = employee.getInService();
		if(!UtilHelper.isEmpty(inService) && 1 == employee.getInService().intValue() ){
			throw new ServiceException(ExceptionDef.ERROR_EMPLOYEE_OUTOFSERVICE.getName());
		}
		Long uId =employee.getuId();
		if(!UtilHelper.isEmpty(uId)){
			throw new ServiceException(ExceptionDef.ERROR_EMPLOYEE_USER_BIND.getName());
		}
		user.setCompanyId(userContext.getCompanyId().intValue());
		user.setPassword(MD5Utils.encrypt(PASSWORD));
		user.setIsInactive(1);
		user.setCreatedBy(userContext.getUser().getUserCode());
		user.setCreatedTime(systemDateService.getCurrentDate());
		userService.save(user);
		UserDto u= userService.findByName(userCode);
		employee.setuId(u.getId());
		employeeService.update(employee);
	}
	
	/**
	 * 更换账号绑定员工
	 * @return
	 * @throws ServiceException
	 */
	public void editUser(String token,EmpUserDto empUserDto) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}	
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		if(UtilHelper.isEmpty(empUserDto.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		String userCode = empUserDto.getUserCode();
		User tempUser = new User();
		tempUser.setUserCode(userCode);
		List<User> userList = userService.listByProperty(tempUser);
		Integer userStatus = userList.get(0).getIsInactive();
		if(IS_INACTIVE.equals(userStatus)){
			throw new ServiceException(ExceptionDef.ERROR_EMPLOYEE_OUTOFSERVICE.getName());
		}
		Long empId = empUserDto.getId();
		
		Employee employee = employeeMapper.getByPK(empId);
		if(UtilHelper.isEmpty(employee)){
			throw new ServiceException(ExceptionDef.ERROR_EMPLOYEE_NONEXIST.getName());
		}
		Long uId = employee.getuId();
		Employee tempEmp = new Employee();
		tempEmp.setId(empId);
		tempEmp.setuId(uId);
		List<Employee> list = employeeMapper.listByProperty(tempEmp);
		if(!UtilHelper.isEmpty(uId)&&UtilHelper.isEmpty(list)){
			throw new ServiceException(ExceptionDef.ERROR_EMPLOYEE_USER_BIND.getName());
		}
		
		Employee formerEmp = new Employee();
		Long formerUID = userList.get(0).getId();
		formerEmp.setuId(formerUID);
		List<Employee> formerList = employeeMapper.listByProperty(formerEmp);
		if(!UtilHelper.isEmpty(formerList)){
			//旧员工解绑
			Employee emp = formerList.get(0);
			emp.setuId(null);
			employeeService.update(emp);
		}
		//账号绑定新员工
		employee.setuId(formerUID);
		employeeService.update(employee);
		
	}

	/**
	 * 通过主键获取员工信息
	 * @return
	 * @throws ServiceException
	 */
	public EmpResponseDto getByPKey(Long primaryKey) throws ServiceException {
		if(UtilHelper.isEmpty(primaryKey)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		Employee emp = employeeService.getByPK(primaryKey);
		EmpResponseDto erd = new EmpResponseDto();
		BeanUtils.copyProperties(emp, erd);
		OrganizationDto org = organizationMapper.getByPKs(Long.valueOf(erd.getOrgId()));
		if(!UtilHelper.isEmpty(org)){
			erd.setOrgName(org.getOrgName());
		}
		Duty duty = dutyMapper.getByPK(Long.valueOf(erd.getDutyId()));
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
			throw new ServiceException(ExceptionDef.ERROR_EMPLOYEE_NONEXIST.getName());
		}
		return erdList;
	}
	/**
	 * 根据主键删除记录
	 */
	public int updateIsHistory(Long primaryKey) throws ServiceException{
		return employeeMapper.updateIsHistory(primaryKey);
	}
	/**
	 * 根据多个主键删除记录
	 * */
	public void updateIsHistorys(List<Long> primaryKeys) throws ServiceException{
		employeeMapper.updateIsHistorys(primaryKeys);
	}

}
