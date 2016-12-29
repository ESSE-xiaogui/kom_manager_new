package com.transsion.store.facade;

import java.util.List;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.dto.TaskDto;

public interface TaskFacade {

	/**
	 *  批量导入
	 * 
	 * */
	public void saveTask(TaskDto taskDto, String token) throws ServiceException;
	
	public List<TaskDto> findTask(String token, TaskDto taskDto) throws ServiceException;
}
