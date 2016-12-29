package com.transsion.store.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.dto.TaskDto;
import com.transsion.store.facade.TaskFacade;
import com.transsion.store.manager.TaskManager;


@Component("taskFacade")
public class TaskFacadeImpl implements TaskFacade{

	@Autowired
	private TaskManager taskManager;
	
	
	public void saveTask(TaskDto taskDto,String token) throws ServiceException {
		taskManager.saveTask(taskDto,token);
	}
	
	public List<TaskDto> findTask(String token, TaskDto taskDto) throws ServiceException{
		return taskManager.findTask(token, taskDto);
	}

}
