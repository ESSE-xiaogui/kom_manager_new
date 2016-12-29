package com.transsion.store.manager;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.batch.task.msg.api.ProducerService;
import com.batch.task.msg.api.TaskMessage;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Task;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.TaskDto;
import com.transsion.store.mapper.TaskMapper;
import com.transsion.store.message.MessageConstant;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("taskManager")
public class TaskManager {
	
	@Autowired
	private TaskMapper taskMapper;
	
	@Autowired
	private SystemDateService systemDateService;
	
	@Autowired
	private ProducerService producerService;
	
	public void saveTask(TaskDto taskDto,String token) throws ServiceException {
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		if(UtilHelper.isEmpty(taskDto)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		if(UtilHelper.isEmpty(taskDto.getTaskType()) || UtilHelper.isEmpty(taskDto.getFileName()) 
				|| UtilHelper.isEmpty(taskDto.getUserName()) || UtilHelper.isEmpty(taskDto.getUploadPath())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		Task task = new Task();
		task.setTaskType(taskDto.getTaskType());
		task.setFileName(taskDto.getFileName());
		task.setUploadPath(taskDto.getUploadPath());
		task.setStage(1);
		task.setUploadTime(systemDateService.getCurrentDate());
		task.setUserName(taskDto.getUserName());
		task.setRemark(taskDto.getRemark());
		taskMapper.saveTask(task);
		TaskMessage msg = new TaskMessage();
		msg.setGroup(MessageConstant.GROUP_NAME);
		msg.setName(MessageConstant.NAME + msg.getTimestamp());
		msg.setBeanName("taskSaleService");
		msg.setMethod("getSaleTaskDto");
		msg.setParams(task);
		producerService.sendMessage(msg);
	}
	public List<TaskDto> findTask(String token, TaskDto taskDto) throws ServiceException{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_TOKEN_INVALID);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		return taskMapper.findTask(taskDto);
	}
}
