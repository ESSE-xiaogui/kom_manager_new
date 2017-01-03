package com.transsion.store.facade;

import java.util.List;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Task;
import com.transsion.store.dto.TaskDto;

public interface TaskFacade {

	/**
	 *  批量导入
	 * 
	 * */
	public void saveTask(TaskDto taskDto, String token) throws ServiceException;
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Task> listPaginationByProperty(Pagination<Task> pagination, Task task)
			throws ServiceException;
	
	public List<Task> findTask(String token, Task task) throws ServiceException;
}
