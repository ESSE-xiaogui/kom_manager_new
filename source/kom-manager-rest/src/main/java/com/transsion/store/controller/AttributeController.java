package com.transsion.store.controller;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rest.service.controller.AbstractController;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Attribute;
import com.transsion.store.bo.Attribute.Type;
import com.transsion.store.facade.AttributeFacade;

@Controller
@Path("attribute")
public class AttributeController extends AbstractController{
	@Autowired
	private AttributeFacade attributeFacade;
	
	/**
	 * 根据类型获取属性列表
	 * @param type
	 * @return
	 */
	@GET
	@Path("/getAttributeListByType")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Attribute> getAttributeListByType(@QueryParam("type") Integer type)throws ServiceException{
		String token = this.getAuthorization();
		return attributeFacade.getAttributeListByType(type,token);
	}
	
}
