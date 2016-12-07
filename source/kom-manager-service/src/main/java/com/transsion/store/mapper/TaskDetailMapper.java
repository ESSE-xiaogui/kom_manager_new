package com.transsion.store.mapper;

import org.apache.ibatis.annotations.Param;

import com.shangkang.core.exception.DataAccessFailureException;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.transsion.store.bo.TaskDetail;

public interface TaskDetailMapper extends GenericIBatisMapper<TaskDetail, java.lang.Long>{
	public void saveTaskDetail(@Param("taskDetail")TaskDetail taskDetail) throws DataAccessFailureException;
}
