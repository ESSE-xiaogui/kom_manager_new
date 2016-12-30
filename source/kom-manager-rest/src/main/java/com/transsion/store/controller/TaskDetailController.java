package com.transsion.store.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rest.service.controller.AbstractController;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.TaskDetail;
import com.transsion.store.facade.TaskDetailFacade;
@Controller
@Path("taskDetail")
public class TaskDetailController extends AbstractController{

	@Autowired
	private TaskDetailFacade taskDetailFacade;
	
	/**
	 * 查询上传信息
	 * */
	@POST
	@Path("findTaskDetail")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<TaskDetail> findTaskDetail(@QueryParam("taskId") Long taskId) throws ServiceException{
		return taskDetailFacade.findTaskDetail(taskId);
	}
	
}