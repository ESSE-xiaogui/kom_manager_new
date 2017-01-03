package com.transsion.store.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.TaskDetail;
import com.transsion.store.mapper.TaskDetailMapper;

@Service("taskDetailService")
public class TaskDetailService {
	
	@Autowired
	private TaskDetailMapper taskDetailMapper;
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<TaskDetail> listPaginationByProperty(Pagination<TaskDetail> pagination, TaskDetail taskDetail)
			throws ServiceException
	{
		List<TaskDetail> list = taskDetailMapper.listPaginationByProperty(pagination, taskDetail, pagination.getOrderBy());
		
		pagination.setResultList(list);
		
		return pagination;
	}
}
