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
import com.transsion.store.dto.ShopLoginDto;
import com.transsion.store.dto.ShopUploadDto;
import com.transsion.store.dto.ShopUserDto;
import com.shangkang.core.dto.RequestModel;
import com.transsion.store.facade.ShopFacade;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@Path("shop")
public class ShopController extends AbstractController {

	@Autowired
	private ShopFacade shopFacade;

	/**
	 * 通过主键查询实体对象
	 * 
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/getByPK")
	@Produces({ MediaType.APPLICATION_JSON })
	public ShopInfoDto getByPKey(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException {
		return shopFacade.getByPKey(primaryKey);
	}

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
	public Pagination<ShopInfoDto> listPgShop(RequestModel<ShopInfoDto> requestModel) throws ServiceException {
		Pagination<ShopInfoDto> pagination = new Pagination<ShopInfoDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return shopFacade.listPaginationByProperty(pagination, requestModel.getParams(), this.getAuthorization());
	}

	/**
	 * 新增记录
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@POST
	@Path("/add")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void add(Shop shop) throws ServiceException {
		shopFacade.save(shop);
	}

	/**
	 * 根据多条主键值删除记录
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@POST
	@Path("/delete")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void delete(List<java.lang.Long> primaryKeys) throws ServiceException {
		shopFacade.deleteByPKeys(primaryKeys);
	}

	/**
	 * 修改记录
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@PUT
	@Path("/update")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void updateShopInfo(ShopInfoDto shopInfoDto) throws ServiceException {
		shopFacade.updateShopInfo(shopInfoDto, this.getAuthorization());
	}

	/**
	 * 用户已绑定的店铺: 前端未调用
	 */
	@GET
	@Path("/findShopUser")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<ShopUserDto> findShopUser() throws ServiceException {
		String token = this.getAuthorization();
		return shopFacade.findShopUser(token);
	}

	/**
	 * 用户已绑定的店铺 : 前端未调用
	 */
	@GET
	@Path("/findShop")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<ShopUserDto> findShop() throws ServiceException {
		String token = this.getAuthorization();
		return shopFacade.findShop(token);
	}

	/**
	 * 门店授权管理:获取此用户已绑定的所有店铺ID
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/findShopIds")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Long> findShopIds(@QueryParam("userName") String userName) throws ServiceException {
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
	 * 
	 * @param token
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/queryShopDefitionDto")
	@Produces({ MediaType.APPLICATION_JSON })
	public ShopDefinitionDto queryShopDefitionDto() throws ServiceException {
		String token = this.getAuthorization();
		return shopFacade.queryShopDefitionDto(token);
	}

	/**
	 * app create shop
	 * 
	 * @throws ServiceException
	 */
	@POST
	@Path("/createShop")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public ShopUploadDto createShop(ShopDetailDto shopDetailDto) throws ServiceException {
		String token = this.getAuthorization();
		return shopFacade.createShop(token, shopDetailDto);
	}

	/**
	 * app shop list
	 * 
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
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Integer updateShop(ShopDetailDto shopDetailDto) throws ServiceException {
		String token = this.getAuthorization();
		return shopFacade.updateShop(token, shopDetailDto);
	}

	/**
	 * 门店审核
	 * 
	 * @param shop
	 * @throws ServiceException
	 */
	@PUT
	@Path("/updateShopStatus")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void updateShopStatus(Shop shop) throws ServiceException {
		String token = this.getAuthorization();
		shopFacade.updateShopStatus(shop, token);
	}
	
	/**
	 * 查询用户绑定店铺
	 */
	@GET
	@Path("/findShopListByUser")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<ShopLoginDto> findShopListByUser()throws ServiceException{
		return shopFacade.findShopListByUser(this.getAuthorization());
	}

	/**
	 * 门店导出Excel
	 * @param createDateStart
	 * @param createDateEnd
	 * @param updateDateStart
	 * @param updateDateEnd
	 * @param bizId
	 * @param gradeId
	 * @param regionId
	 * @param address
	 * @param shopId
	 * @param status
	 * @return
	 * @throws ServiceException
	 * @throws IOException
	 */
	@GET
	@Path("/exportExcel") 
	@Produces({MediaType.TEXT_PLAIN})  
	public Response getShopByExcel(@QueryParam("createDateStart") String createDateStart,
		@QueryParam("createDateEnd") String createDateEnd,@QueryParam("updateDateStart") String updateDateStart,
		@QueryParam("updateDateEnd") String updateDateEnd,@QueryParam("bizId") String bizId,
		@QueryParam("gradeId") String gradeId,@QueryParam("regionId")String regionId,
		@QueryParam("address")String address,@QueryParam("shopCode")String shopCode,
		@QueryParam("status") String status,@QueryParam("companyId") String companyId,
		@QueryParam("shopName") String shopName,@QueryParam("isInactive") String isInactive) throws ServiceException,IOException {
		ShopInfoDto shopInfoDto = new ShopInfoDto();
		shopInfoDto.setCreateDateStart(createDateStart);
		shopInfoDto.setCreateDateEnd(createDateEnd);
		shopInfoDto.setUpdateDateStart(updateDateStart);
		shopInfoDto.setUpdateDateEnd(updateDateEnd);
		shopInfoDto.setShopName(shopName);
		shopInfoDto.setShopCode(shopCode);
		if(!UtilHelper.isEmpty(bizId)){
			shopInfoDto.setBizId(Long.parseLong(bizId));
		}
		if(!UtilHelper.isEmpty(gradeId)){
			shopInfoDto.setGradeId(Long.parseLong(gradeId));
		}
		if(!UtilHelper.isEmpty(regionId)){
			shopInfoDto.setRegionId(Long.parseLong(regionId));
		}
		if(!UtilHelper.isEmpty(status)){
			shopInfoDto.setStatus(Integer.valueOf(status));
		}
		if(!UtilHelper.isEmpty(companyId)){
			shopInfoDto.setCompanyId(Integer.valueOf(companyId));
		}
		if(!UtilHelper.isEmpty(isInactive)){
			shopInfoDto.setIsInactive(Integer.valueOf(isInactive));
		}
		shopInfoDto.setAddress(address);
		byte[] bytes = shopFacade.getShopByExcel(shopInfoDto);       
		InputStream inputStream = new ByteArrayInputStream(bytes);          
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));          
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"门店报表.xlsx";
		response.header("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"), "iso-8859-1"));         
		//根据自己文件类型修改         
		response.header("ContentType", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");          
		return response.build();      	
	}
	class BigFileOutputStream implements javax.ws.rs.core.StreamingOutput {
        private InputStream inputStream;
        public BigFileOutputStream(){}
        public BigFileOutputStream(InputStream inputStream)
        {
            this.inputStream = inputStream;
        }

        @Override
        public void write(OutputStream output) throws IOException,
                WebApplicationException {
            // TODO Auto-generated method stub
            IOUtils.copy(inputStream, output);
        }

        public InputStream getInputStream() {
            return inputStream;
        }
        public void setInputStream(InputStream inputStream) {
            this.inputStream = inputStream;
        }
    }
}
