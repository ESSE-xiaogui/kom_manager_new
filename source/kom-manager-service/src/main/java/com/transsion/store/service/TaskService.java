package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Task;
import com.transsion.store.mapper.TaskMapper;

@Service("taskService")
public class TaskService {
	
	@Autowired
	private TaskMapper taskMapper;
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Task> listPaginationByProperty(Pagination<Task> pagination, Task task)
			throws ServiceException
	{
		List<Task> list = taskMapper.listPaginationByProperty(pagination, task, pagination.getOrderBy());
		
		pagination.setResultList(list);
		
		return pagination;
	}
}
