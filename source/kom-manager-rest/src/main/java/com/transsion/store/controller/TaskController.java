package com.transsion.store.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rest.service.controller.AbstractController;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.dto.RequestModel;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Task;
import com.transsion.store.dto.TaskDto;
import com.transsion.store.facade.TaskFacade;
@Controller
@Path("task")
public class TaskController extends AbstractController{

	@Autowired
	private TaskFacade taskFacade;
	
	/**
	 * @author guihua.zhang
	 * @see 删除任务
	 * CREATE TIME 2017-2-20
	 * */
	@POST
	@Path("delete")
	public void delete(List<Long> primaryKeys) throws ServiceException{
		taskFacade.delete(primaryKeys);
	}
	
	/**
	 * @author guihua.zhang
	 * @see 批量导入
	 * */
	@POST
	@Path("/saveTask")
	@Consumes({MediaType.APPLICATION_JSON})
	public void saveTask(TaskDto taskDto) throws ServiceException{
		String token = this.getAuthorization();
		taskFacade.saveTask(taskDto,token);
	}
	
	/**
	 * @author guihua.zhang
	* @see分页查询记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/listPg")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pagination<Task> listPgTask(RequestModel<Task> requestModel) throws ServiceException
	{
		Pagination<Task> pagination = new Pagination<Task>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return taskFacade.listPaginationByProperty(pagination, requestModel.getParams());
	}
	
	/**
	 * @author guihua.zhang
	 * @see 查询上传信息
	 * */
	@POST
	@Path("findTask")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<Task> findTask(Task task) throws ServiceException{
		String token = this.getAuthorization();
		return taskFacade.findTask(token, task);
	}
	
}
