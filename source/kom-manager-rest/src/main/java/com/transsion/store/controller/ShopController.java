/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 15:56:39
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.controller;

import com.rest.service.controller.AbstractController;
import com.transsion.store.bo.Shop;
import com.transsion.store.dto.ShopDefinitionDto;
import com.transsion.store.dto.ShopDetailDto;
import com.transsion.store.dto.ShopInfoDto;
import com.transsion.store.dto.ShopUserDto;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.ShopFacade;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path("shop")
public class ShopController extends AbstractController{

	@Autowired
	private ShopFacade shopFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public Shop getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return shopFacade.getByPK(primaryKey);
	}

	/**
	* 分页查询记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/listPg")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pagination<ShopInfoDto> listPgShop(RequestModel<ShopInfoDto> requestModel) throws ServiceException
	{
		Pagination<ShopInfoDto> pagination = new Pagination<ShopInfoDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return shopFacade.listPaginationByProperty(pagination, requestModel.getParams(),this.getAuthorization());
	}

	/**
	* 新增记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	public void add(Shop shop) throws ServiceException
	{
		shopFacade.save(shop);
	}

	/**
	* 根据多条主键值删除记录
	* @return
	* @throws ServiceException
	*/
	@POST
	@Path("/delete")
	@Consumes({MediaType.APPLICATION_JSON})
	public void delete(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		shopFacade.deleteByPKeys(primaryKeys);
	}

	/**
	* 修改记录
	* @return
	* @throws ServiceException
	*/
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void updateShopInfo(ShopInfoDto shopInfoDto) throws ServiceException
	{
		shopFacade.updateShopInfo(shopInfoDto,this.getAuthorization());
	}
	
	/**
	 * 用户已绑定的店铺: 前端未调用
	 * */
	@GET
	@Path("/findShopUser")
	@Produces({MediaType.APPLICATION_JSON})
	public List<ShopUserDto> findShopUser() throws ServiceException{
		String token =this.getAuthorization();
		return shopFacade.findShopUser(token);
	}
	
	/**
	 * 用户已绑定的店铺 : 前端未调用
	 * */
	@GET
	@Path("/findShop")
	@Produces({MediaType.APPLICATION_JSON})
	public List<ShopUserDto> findShop() throws ServiceException{
		String token =this.getAuthorization();
		return shopFacade.findShop(token);
	}
	
	/**
	 * 门店授权管理:获取此用户已绑定的所有店铺ID
	 * @return
	 * @throws ServiceException
	 * */
	@GET
	@Path("/findShopIds")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<Long> findShopIds(@QueryParam("userName") String userName) throws ServiceException{
		return shopFacade.findShopIds(userName);
	}
	
	/**
	 * 获取促销员店铺
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/shops")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Shop> findShops() throws ServiceException {
		String token = this.getAuthorization();
		return shopFacade.queryPromoterShop(token);
	}	
	
	/**
	 * 查询门店定义
	 * @param token
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/queryShopDefitionDto")
	@Produces({ MediaType.APPLICATION_JSON })
	public ShopDefinitionDto queryShopDefitionDto() throws ServiceException{
		String token = this.getAuthorization();
		return shopFacade.queryShopDefitionDto(token);	
	}
	
	/**
	 * app create shop
	 * @throws ServiceException
	 */
	@POST
	@Path("/createShop")
	@Consumes({MediaType.APPLICATION_JSON})
	public void createShop(ShopDetailDto shopDetailDto) throws ServiceException{
		String token = this.getAuthorization();
		shopFacade.createShop(token, shopDetailDto);
	}
	
	/**
	 * app shop list
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/queryManagedShopList")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<ShopDetailDto> queryManagedShopList() throws ServiceException {
		String token = this.getAuthorization();
		return shopFacade.queryManagedShopList(token);
	}
	
	@PUT
	@Path("/updateShop")
	@Consumes({MediaType.APPLICATION_JSON})
	public void updateShop(ShopDetailDto shopDetailDto) throws ServiceException {
		String token = this.getAuthorization();
		shopFacade.updateShop(token, shopDetailDto);
	}
	
	/**
	 * 门店审核
	 * @param shop
	 * @throws ServiceException
	 */
	@PUT
	@Path("/updateShopStatus")
	@Consumes({MediaType.APPLICATION_JSON})
	public void updateShopStatus(Shop shop)throws ServiceException{
		String token = this.getAuthorization();
		shopFacade.updateShopStatus(shop,token);
	}
}
