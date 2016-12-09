package com.transsion.store.mapper;

import com.shangkang.core.exception.DataAccessFailureException;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.transsion.store.bo.Task;

public interface TaskMapper extends GenericIBatisMapper<Task, java.lang.Long>{
	public void saveTask(Task task) throws DataAccessFailureException;
}
