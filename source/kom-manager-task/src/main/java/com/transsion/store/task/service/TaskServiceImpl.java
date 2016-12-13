package com.transsion.store.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.mapper.TaskMapper;
import com.transsion.store.task.interfaces.TaskService;

@Service("taskService")
public class TaskServiceImpl implements TaskService{
	@Autowired
	private TaskMapper taskMapper;
	/**
	 * 上传文件路径查询
	 * */
	public String findUploadPath(String taskType) throws ServiceException {
		if (!UtilHelper.isEmpty(taskType)) {
			String uploadPath = taskMapper.findUploadPath(taskType);
			if (!UtilHelper.isEmpty(uploadPath)) {
				return uploadPath;
			}
			return null;
		}
		return null;
	}
	
}
