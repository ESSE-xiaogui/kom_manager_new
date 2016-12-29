package com.transsion.store.manager;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.TaskDetail;
import com.transsion.store.mapper.TaskDetailMapper;

@Service("taskDetailManager")
public class TaskDetailManager {
	
	@Autowired
	private TaskDetailMapper taskDetailMapper;
	
	public List<TaskDetail> findTaskDetail(Long taskId) throws ServiceException{
		return taskDetailMapper.findTaskDetail(taskId);
	}
}
