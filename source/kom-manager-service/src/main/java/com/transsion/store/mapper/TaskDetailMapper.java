package com.transsion.store.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shangkang.core.exception.DataAccessFailureException;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.transsion.store.bo.TaskDetail;

public interface TaskDetailMapper extends GenericIBatisMapper<TaskDetail, java.lang.Long>{
	public void saveTaskDetail(TaskDetail taskDetail) throws DataAccessFailureException;
	public List<TaskDetail> findTaskDetail(@Param("taskId")Long taskId) throws DataAccessFailureException;
}
