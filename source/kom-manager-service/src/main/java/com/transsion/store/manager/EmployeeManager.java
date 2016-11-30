package com.transsion.store.manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Employee;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.EmpResponseDto;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.service.EmployeeService;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("employeeManager")
public class EmployeeManager {
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private SystemDateService systemDateService;
	
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
}
