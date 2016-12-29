package com.transsion.store.facade.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.TaskDetail;
import com.transsion.store.facade.TaskDetailFacade;
import com.transsion.store.manager.TaskDetailManager;
@Component("taskDetailFacade")
public class TaskDetailFacadeImpl implements TaskDetailFacade{

	@Autowired
	private TaskDetailManager taskDetailManager;
	
	public List<TaskDetail> findTaskDetail(Long taskId) throws ServiceException{
		return taskDetailManager.findTaskDetail(taskId);
	}

}
