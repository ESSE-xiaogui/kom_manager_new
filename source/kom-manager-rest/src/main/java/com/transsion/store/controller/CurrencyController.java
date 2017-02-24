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
import com.transsion.store.bo.Currency;
import com.transsion.store.dto.CurrencyDto;
import com.transsion.store.dto.CurrencyResultDto;
import com.transsion.store.facade.CurrencyFacade;
@Controller
@Path("currency")
public class CurrencyController extends AbstractController{
	
	@Autowired
	private CurrencyFacade currencyFacade;
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 * 
	 */
	@GET
	@Path("/getByPK")
	@Produces({MediaType.APPLICATION_JSON})
	public Currency getByPK(@QueryParam("key") java.lang.Long primaryKey) throws ServiceException
	{
		return currencyFacade.getByPK(primaryKey);
	}
	
	/**
	 * 新增汇率
	 * @return
	 * @throws ServiceException
	 * */
	@POST
	@Path("/add")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public void saveCurrency(Currency currency) throws ServiceException{
		String token = this.getAuthorization();
		currencyFacade.saveCurrency(currency,token);
	}
	
	/**
	 * 查询汇率
	 * */
	@POST
	@Path("/listPg")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pagination<CurrencyDto> listPgCurrency(RequestModel<CurrencyDto> requestModel) throws ServiceException{
		Pagination<CurrencyDto> pagination = new Pagination<CurrencyDto>();
		pagination.setPaginationFlag(requestModel.isPaginationFlag());
		pagination.setPageNo(requestModel.getPageNo());
		pagination.setPageSize(requestModel.getPageSize());
		pagination.setParams(requestModel.getParams());
		pagination.setOrderBy(requestModel.getOrderBy());
		return currencyFacade.listPaginationByProperty(pagination, pagination.getParams());
	}
	
	/**
	 * 更新汇率
	 * */
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	public void updateCurrency(Currency currency) throws ServiceException{
		String token=this.getAuthorization();
		currencyFacade.updateCurrency(currency,token);
	}
	
	/**
	 * 删除汇率
	 * */
	@POST
	@Path("/delete")
	@Consumes({MediaType.APPLICATION_JSON})
	public void delete(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		currencyFacade.deleteByPKeys(primaryKeys);
	}
	
	/**
	 * 汇率导出Excel
	 * @param currencyDto
	 * @return
	 * @throws ServiceException
	 * @throws IOException
	 */
	@GET
	@Path("/exportExcel")
	@Produces({MediaType.TEXT_PLAIN})  
	public Response getCurrencyByExcel(@QueryParam("beginTime")String beginTime,@QueryParam("endTime")String endTime,
		@QueryParam("expiryDate")String expiryDate,@QueryParam("expiryEndDate") String expiryEndDate,
		@QueryParam("regionId")String regionId,@QueryParam("currencyName")String currencyName,
		@QueryParam("isInactive")String isInactive
		) throws ServiceException,IOException {
		CurrencyDto currencyDto = new CurrencyDto();
		currencyDto.setBeginTime(beginTime);
		currencyDto.setEndTime(endTime);
		currencyDto.setExpiryDate(expiryDate);
		currencyDto.setExpiryEndDate(expiryEndDate);
		currencyDto.setCurrencyName(currencyName);
		if(!UtilHelper.isEmpty(regionId)){
			currencyDto.setRegionId(Long.parseLong(regionId));
		}
		if(!UtilHelper.isEmpty(isInactive)){
			currencyDto.setIsInactive(Integer.valueOf(isInactive));
		}
		byte[] bytes = currencyFacade.getCurrencyByExcel(currencyDto);       
		InputStream inputStream = new ByteArrayInputStream(bytes);          
		Response.ResponseBuilder response = Response.ok(new BigFileOutputStream(inputStream));          
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())+"汇率报表.xlsx";
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
            IOUtils.copy(inputStream, output);
        }

        public InputStream getInputStream() {
            return inputStream;
        }
        public void setInputStream(InputStream inputStream) {
            this.inputStream = inputStream;
        }
    }
	
	/**
	 * @author guihua.zhang on 2017-2-21
	 * @return
	 * @throws ServiceException
	 * */
	@GET
	@Path("/findCurrencyName")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<CurrencyResultDto> findCurrencyName() throws ServiceException{
		return currencyFacade.findCurrencyName();
	}
}
