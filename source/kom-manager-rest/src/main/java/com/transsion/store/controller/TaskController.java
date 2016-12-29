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
	@Path("/saveTask")
	@Consumes({MediaType.APPLICATION_JSON})
	public void saveTask(TaskDto taskDto) throws ServiceException{
		String token = this.getAuthorization();
		taskFacade.saveTask(taskDto,token);
	}
	
	/**
	 * 查询上传信息
	 * */
	@POST
	@Path("findTask")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<TaskDto> findTask(TaskDto taskDto) throws ServiceException{
		String token = this.getAuthorization();
		return taskFacade.findTask(token, taskDto);
	}
	
}
