package com.transsion.store.mapper;
import java.util.List;
import com.shangkang.core.exception.DataAccessFailureException;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.transsion.store.bo.Task;
import com.transsion.store.dto.TaskDto;

public interface TaskMapper extends GenericIBatisMapper<Task, java.lang.Long>{
	public void saveTask(Task task) throws DataAccessFailureException;
	public List<TaskDto> findTask (TaskDto taskDto) throws DataAccessFailureException;
}
