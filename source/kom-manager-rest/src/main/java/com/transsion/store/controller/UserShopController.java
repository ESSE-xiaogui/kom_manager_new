package com.transsion.store.controller;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.rest.service.controller.AbstractController;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.dto.UserShopDto;
import com.transsion.store.facade.UserShopFacade;

@Controller
@Path("userShop")
public class UserShopController extends AbstractController{
	@Autowired
	private UserShopFacade userShopFacade;

	/**
	 * 门店授权管理:用户绑定门店
	 * */
	@POST
	@Path("/saveUserShop")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void saveUserShop(UserShopDto userShopDto) throws ServiceException{
		userShopFacade.saveUserShop(userShopDto);
	}

}
