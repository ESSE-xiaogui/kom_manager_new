package com.transsion.store.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.transsion.store.bo.Task;

public interface TaskMapper extends GenericIBatisMapper<Task, java.lang.Long>{
	public void saveTask(Task task) throws DataAccessFailureException;
	public List<Task> findTask (Task task) throws DataAccessFailureException;
	public List<Task> listPaginationByProperty(Pagination<Task> pagination, @Param("task")Task task, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;

}
