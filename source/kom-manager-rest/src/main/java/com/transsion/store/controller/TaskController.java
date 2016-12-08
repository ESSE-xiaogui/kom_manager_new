package com.transsion.store.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rest.service.controller.AbstractController;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.dto.TaskDto;
import com.transsion.store.facade.TaskFacade;
@Controller
@Path("task")
public class TaskController extends AbstractController{

	@Autowired
	private TaskFacade taskFacade;
	
	/**
	 * 批量导入
	 * */
	@POST
	@Path("/batchTask")
	@Consumes({MediaType.APPLICATION_JSON})
	private void batchTask(TaskDto taskDto) throws ServiceException{
		taskFacade.saveTask(taskDto);
	}
}
