package com.transsion.store.facade.impl;

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
	
	
	public void saveTask(TaskDto taskDto) throws ServiceException {
		taskManager.saveTask(taskDto);
	}

}
