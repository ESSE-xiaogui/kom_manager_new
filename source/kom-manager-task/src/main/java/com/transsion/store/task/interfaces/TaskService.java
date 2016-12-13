package com.transsion.store.task.interfaces;

import com.shangkang.core.exception.ServiceException;

public interface TaskService {

	/**
	 * 上传文件路径查询
	 * */
	public String findUploadPath(String taskType) throws ServiceException;
}
