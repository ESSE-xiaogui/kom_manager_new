package com.transsion.store.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.rest.service.controller.AbstractController;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.dto.RequestModel;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.TaskDetail;
import com.transsion.store.dto.TaskItemDto;
import com.transsion.store.facade.TaskDetailFacade;

@Controller
@Path("taskDetail")
public class TaskDetailController extends AbstractController {

	@Autowired
	private TaskDetailFacade taskDetailFacade;

	/**
	 * 分页查询记录
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@POST
	@Path("/listPg")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Pagination<TaskDetail> listPgTaskDetail(RequestModel<TaskDetail> requestModel) throws ServiceException {
		Pagination<TaskDetail> pagination = new Pagination<TaskDetail>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return taskDetailFacade.listPaginationByProperty(pagination, requestModel.getParams());
	}

	/**
	 * 查询上传信息
	 */
	@GET
	@Path("findTaskDetail")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public List<TaskDetail> findTaskDetail(@QueryParam("taskId") Long taskId) throws ServiceException {
		return taskDetailFacade.findTaskDetail(taskId);
	}
	
	/**
	 * @author guihua.zhang on 2017-2-21
	 * 
	 * 统计成功条数,失败条数
	 * @return
	 * @throws ServiceException
	 * */
	@GET
	@Path("/findTaskItemNum")
	@Produces({ MediaType.APPLICATION_JSON })
	public TaskItemDto findTaskItemNum(@QueryParam("taskId") Long taskId) throws ServiceException{
		return taskDetailFacade.findTaskItemNum(taskId);
	}
}
