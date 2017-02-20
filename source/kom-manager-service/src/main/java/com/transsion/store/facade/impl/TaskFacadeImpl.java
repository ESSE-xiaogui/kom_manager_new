package com.transsion.store.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Task;
import com.transsion.store.dto.TaskDto;
import com.transsion.store.facade.TaskFacade;
import com.transsion.store.manager.TaskManager;
import com.transsion.store.service.TaskService;


@Component("taskFacade")
public class TaskFacadeImpl implements TaskFacade{

	@Autowired
	private TaskManager taskManager;
	
	@Autowired
	private TaskService taskService;
	
	/**
	 * 删除任务
	 * */
	public void delete(List<Long> primaryKeys) throws ServiceException{
		taskManager.delete(primaryKeys);
	}
	
	public void saveTask(TaskDto taskDto,String token) throws ServiceException {
		taskManager.saveTask(taskDto,token);
	}
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Task> listPaginationByProperty(Pagination<Task> pagination, Task task)
			throws ServiceException{
		return taskService.listPaginationByProperty(pagination, task);
	}
	public List<Task> findTask(String token, Task task) throws ServiceException{
		return taskManager.findTask(token, task);
	}

}
