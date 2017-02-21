package com.transsion.store.facade;
import java.util.List;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.TaskDetail;
import com.transsion.store.dto.TaskItemDto;
public interface TaskDetailFacade {
	public List<TaskDetail> findTaskDetail(Long taskId) throws ServiceException;
	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<TaskDetail> listPaginationByProperty(Pagination<TaskDetail> pagination, TaskDetail taskDetail)
			throws ServiceException;
	/**
	 * 统计成功条数,失败条数
	 * @return
	 * @throws ServiceException
	 * */
	public TaskItemDto findTaskItemNum(Long taskId) throws ServiceException;
}
