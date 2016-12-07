package com.transsion.store.manager;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Task;
import com.transsion.store.dto.TaskDto;
import com.transsion.store.mapper.TaskMapper;
import com.transsion.store.message.MessageService;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.service.SystemDateService;

@Service("taskManager")
public class TaskManager {
	
	@Autowired
	private TaskMapper taskMapper;
	
	@Autowired
	private SystemDateService systemDateService;
	
	@Autowired
	private MessageService messageSevice;
	
	public void saveTask(TaskDto taskDto) throws ServiceException {
		if(UtilHelper.isEmpty(taskDto)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		if(UtilHelper.isEmpty(taskDto.getTaskType()) || UtilHelper.isEmpty(taskDto.getFileName()) 
				|| UtilHelper.isEmpty(taskDto.getUserName())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		Task task = new Task();
		task.setTaskType(taskDto.getTaskType());
		task.setFileName(taskDto.getFileName());
		task.setUploadPath(taskDto.getUploadPath());
		task.setStage(1);
		task.setUploadTime(systemDateService.getCurrentDate());
		task.setUserName(taskDto.getUserName());
		taskMapper.saveTask(task);
		HashMap<String, Object> messages = new HashMap<String, Object>();
		messages.put("type", "task.saveTask");
		messages.put("payload", task);
		messageSevice.sendMessage(messages);
	}
}
