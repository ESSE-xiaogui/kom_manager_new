package com.transsion.store.facade;
import java.util.List;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.TaskDetail;
public interface TaskDetailFacade {
	public List<TaskDetail> findTaskDetail(Long taskId) throws ServiceException;
}
