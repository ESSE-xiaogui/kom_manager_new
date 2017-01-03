package com.transsion.store.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.transsion.store.bo.TaskDetail;

public interface TaskDetailMapper extends GenericIBatisMapper<TaskDetail, java.lang.Long>{
	public void saveTaskDetail(TaskDetail taskDetail) throws DataAccessFailureException;
	public List<TaskDetail> findTaskDetail(@Param("taskId")Long taskId) throws DataAccessFailureException;
	public List<TaskDetail> listPaginationByProperty(Pagination<TaskDetail> pagination, @Param("taskDetail")TaskDetail taskDetail, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;

}
