package com.transsion.store.facade;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.dto.TaskDto;

public interface TaskFacade {

	/**
	 *  批量导入
	 * 
	 * */
	public void saveTask(TaskDto taskDto) throws ServiceException;
}
