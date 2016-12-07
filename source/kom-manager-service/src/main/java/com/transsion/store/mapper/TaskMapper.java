package com.transsion.store.mapper;

import org.apache.ibatis.annotations.Param;

import com.shangkang.core.exception.DataAccessFailureException;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.transsion.store.bo.Task;

public interface TaskMapper extends GenericIBatisMapper<TaskMapper, java.lang.Long>{
	public void saveTask(@Param("task")Task task)throws DataAccessFailureException;
}
