/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 15:56:37
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.controller;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rest.service.controller.AbstractController;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.dto.RequestModel;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Sale;
import com.transsion.store.dto.SaleDailyDto;
import com.transsion.store.dto.SalesDto;
import com.transsion.store.dto.SalesUploadDto;
import com.transsion.store.dto.TShopSaleDto;
import com.transsion.store.facade.SaleFacade;
import com.transsion.store.task.facade.SaleTaskFacade;

@Controller
@Path("sale")
public class SaleController extends AbstractController {

	@Autowired
	private SaleFacade saleFacade;

	@Autowired
	private SaleTaskFacade saleTaskFacade;

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
	public Sale getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException {
		return saleFacade.getByPK(primaryKey);
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
	public Pagination<Sale> listPgSale(RequestModel<Sale> requestModel) throws ServiceException {
		Pagination<Sale> pagination = new Pagination<Sale>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return saleFacade.listPaginationByProperty(pagination, requestModel.getParams());
	}

	/**
	 *  查询销量日报的记录
	 */
	@POST
	@Path("listSale")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Pagination<SaleDailyDto> listPgSales(RequestModel<SaleDailyDto> requestModel) throws ServiceException {
		Pagination<SaleDailyDto> pagination = new Pagination<SaleDailyDto>();

		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());

		return saleFacade.listPaginationByPropertys(pagination, requestModel.getParams());
	}
	
	/**
	 * 销量明细
	 * */
	@GET
	@Path("findSaleItem")
	@Produces({ MediaType.APPLICATION_JSON })
	public SaleDailyDto findSaleItem(@QueryParam("saleId") java.lang.Long saleId) throws ServiceException{
		return saleFacade.findSaleItem(saleId);
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
	public void add(Sale sale) throws ServiceException {
		saleFacade.save(sale);
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
		saleFacade.deleteByPKeys(primaryKeys);
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
	public void update(Sale sale) throws ServiceException {
		saleFacade.update(sale);
	}

	/**
	 * 销量上传[文件导入]
	 */
	@PUT
	@Path("/saveSaleTask/{taskId}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void saveSaleTask(@PathParam("taskId") Long taskId) throws ServiceException {
		saleTaskFacade.saveSaleTask(taskId);
	}

	/**
	 *  销量上报记录
	 * @author guihua.zhang
	 * @return list
	 * @throws ServiceException
	 */
	@POST
	@Path("/saveSalesUpload")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public List<SalesUploadDto> saveSalesUpload(TShopSaleDto tshopSaleDto) throws ServiceException {
		String token = this.getAuthorization();
		return saleFacade.saveSalesUpload(tshopSaleDto, token);
	}

	/**
	 * 销量上报记录查询
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("/findSales")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<SalesDto> findPromoterSales(@QueryParam("startDate") java.lang.String startDate,
					@QueryParam("endDate") java.lang.String endDate, @QueryParam("model") String model)
					throws ServiceException {
		String token = this.getAuthorization();
		return saleFacade.findPromoterSales(token, startDate, endDate, model);
	}

	/**
	 *  用户销量数
	 * @author guihua.zhang
	 * @return
	 * @throws ServiceException
	 */
	@GET
	@Path("findSaleQty")
	@Produces({ MediaType.APPLICATION_JSON })
	public int findSaleQty(@QueryParam("startDate") java.lang.String startDate,
					@QueryParam("endDate") java.lang.String endDate) throws ServiceException {
		String token = this.getAuthorization();
		return saleFacade.findSaleQty(token, startDate, endDate);
	}

	/**
	 * 根据订单号删除记录
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@POST
	@Path("/deleteByBillNo")
	public void deleteByBillNo(String billNo) throws ServiceException {
		String token = this.getAuthorization();
		saleFacade.deleteByBillNo(billNo, token);
	}

	/**
	 * 销量导出Excel
	 * 
	 * @return
	 */
	@GET
	@Path("/exportExcel") 
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})  
	public Response getSaleByExcel(@QueryParam("saleDate") String saleDate,@QueryParam("saleEndDate") String saleEndDate,
					@QueryParam("createdTime") String createdTime,@QueryParam("createdEndTime")String createdEndTime,
					@QueryParam("countryName") String countryName,@QueryParam("cityName") String cityName,
					@QueryParam("shopId") String shopId,@QueryParam("shopName") String shopName,
					@QueryParam("brandCode") String brandCode,@QueryParam("modelCode") String modelCode,
					@QueryParam("imeiNo") String imeiNo,@QueryParam("userName") String userName) throws ServiceException,IOException {
		SaleDailyDto saleDailyDto = new SaleDailyDto();
		saleDailyDto.setSaleDate(saleDate);
		saleDailyDto.setSaleEndDate(saleEndDate);
		saleDailyDto.setCreatedTime(createdTime);
		saleDailyDto.setCreatedEndTime(createdEndTime);
		saleDailyDto.setCountryName(countryName);
		saleDailyDto.setCityName(cityName);
		if(!UtilHelper.isEmpty(shopId)){
			saleDailyDto.setShopId(Integer.valueOf(shopId));
		}
		saleDailyDto.setShopName(shopName);
		saleDailyDto.setBrandCode(brandCode);
		saleDailyDto.setModelCode(modelCode);
		saleDailyDto.setImeiNo(imeiNo);
		saleDailyDto.setUserName(userName);
		byte[] bytes = saleFacade.getSaleByExcel(saleDailyDto, null);       
		InputStream inputStream = new ByteArrayInputStream(bytes);          
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));          
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"销量报表.xlsx";
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
