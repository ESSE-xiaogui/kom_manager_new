package com.transsion.store.facade.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.TaskDetail;
import com.transsion.store.dto.TaskItemDto;
import com.transsion.store.facade.TaskDetailFacade;
import com.transsion.store.manager.TaskDetailManager;
import com.transsion.store.service.TaskDetailService;
@Component("taskDetailFacade")
public class TaskDetailFacadeImpl implements TaskDetailFacade{

	@Autowired
	private TaskDetailManager taskDetailManager;
	
	@Autowired
	private TaskDetailService taskDetailService;
	
	public List<TaskDetail> findTaskDetail(Long taskId) throws ServiceException{
		return taskDetailManager.findTaskDetail(taskId);
	}
	
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<TaskDetail> listPaginationByProperty(Pagination<TaskDetail> pagination, TaskDetail taskDetail)
			throws ServiceException{
		return taskDetailService.listPaginationByProperty(pagination, taskDetail);
	}
	
	/**
	 * 统计成功条数,失败条数
	 * @return
	 * @throws ServiceException
	 * */
	public TaskItemDto findTaskItemNum(Long taskId) throws ServiceException{
		return taskDetailService.findTaskItemNum(taskId);
	}

}
