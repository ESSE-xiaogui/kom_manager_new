package com.transsion.store.manager;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch.task.api.TaskInvokerInfo;
import com.batch.task.msg.api.ProducerService;
import com.batch.task.msg.api.TaskMessage;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Task;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.TaskDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.TaskDetailMapper;
import com.transsion.store.mapper.TaskMapper;
import com.transsion.store.message.Message.Group;
import com.transsion.store.message.Message.Type;
import com.transsion.store.service.ConfigurationService;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("taskManager")
public class TaskManager {
	public static final String IMPORT_TASK_URL = "import.task.url";
	@Autowired
	private TaskMapper taskMapper;
	
	@Autowired
	private TaskDetailMapper taskDetailMapper;
	
	@Autowired
	private SystemDateService systemDateService;
	
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	private ConfigurationService configurationService;
	
	/**
	 * 删除任务
	 * */
	public void delete(List<Long> primaryKeys) throws ServiceException{
		if(UtilHelper.isEmpty(primaryKeys)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		taskDetailMapper.deleteByTaskIds(primaryKeys);
		taskMapper.deleteByPKeys(primaryKeys);
	}
	
	public void saveTask(TaskDto taskDto,String token) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(taskDto)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		if(UtilHelper.isEmpty(taskDto.getTaskType()) || UtilHelper.isEmpty(taskDto.getFileName()) || UtilHelper.isEmpty(taskDto.getUploadPath())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		Task task = new Task();
		task.setTaskType(taskDto.getTaskType());
		task.setFileName(taskDto.getFileName());
		task.setUploadPath(taskDto.getUploadPath());
		task.setStage(1);
		task.setUploadTime(systemDateService.getCurrentDate());
		task.setUserName(userContext.getUserCode());
		task.setRemark(taskDto.getRemark());
		taskMapper.saveTask(task);
		TaskMessage msg = new TaskMessage();
		msg.setGroup(Group.TASK.toString());
		if(task.getTaskType().equals(Type.TASK_CURRENCY_IMPORT.getDesc())){
			msg.setName(Type.TASK_CURRENCY_IMPORT.getDesc());
		}else if(task.getTaskType().equals(Type.TASK_SALE_IMPORT.getDesc())){
			msg.setName(Type.TASK_SALE_IMPORT.getDesc());
		}else if(task.getTaskType().equals(Type.TASK_GOAL_SUPERVISOR_IMPORT.getDesc())){
			msg.setName(Type.TASK_GOAL_SUPERVISOR_IMPORT.getDesc());
		}else if(task.getTaskType().equals(Type.TASK_GOAL_MODEL_IMPORT.getDesc())){
			msg.setName(Type.TASK_GOAL_MODEL_IMPORT.getDesc());
		}else if(task.getTaskType().equals(Type.TASK_GOAL_PROMOTER_IMPORT.getDesc())){
			msg.setName(Type.TASK_GOAL_PROMOTER_IMPORT.getDesc());
		}
		msg.setInvokerType(TaskInvokerInfo.Type.REST);
		msg.setKey(task.getId());
//		msg.setBeanName(Constants.IMPORTTASK + task.getId());
		// 从数据库中读取导入文件的地址
		String importTask = configurationService.getValueByName(IMPORT_TASK_URL);
		msg.setBeanName(importTask + task.getId());
		msg.setMethod(TaskInvokerInfo.RestMethod.PUT.toString());
		msg.setParams(task.getId());
		producerService.sendMessage(msg);
	}
	public List<Task> findTask(String token, Task task) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUserCode())){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		task.setUserName(userContext.getUserCode());
		return  taskMapper.findTask(task);
	}
}
