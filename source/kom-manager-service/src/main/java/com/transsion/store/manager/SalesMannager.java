package com.transsion.store.manager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.ConstantUtil;
import com.transsion.store.bo.Sale;
import com.transsion.store.bo.SaleItem;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.SalesDto;
import com.transsion.store.dto.SalesUploadDto;
import com.transsion.store.dto.ScanValidateDto;
import com.transsion.store.dto.TShopSaleDto;
import com.transsion.store.mapper.CurrencyMapper;
import com.transsion.store.mapper.SaleItemMapper;
import com.transsion.store.mapper.SaleMapper;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("salesMannager")
public class SalesMannager {
	Logger logger = LoggerFactory.getLogger(SalesMannager.class);
	
	@Autowired
	private SaleMapper saleMapper;
	
	@Autowired
	private SaleItemMapper saleItemMapper;
	
	@Autowired
	private CurrencyMapper currencyMapper;
	
	@Autowired
	private ScanValidateManager scanValidateManager;
	
	@Autowired
	private SystemDateService systemDateService;

	
	/**
	 * @see 销量上报记录
	 * @author guihua.zhang
	 * @return list
	 * @throws ServiceException
	 */
	public List<SalesUploadDto> saveSalesUpload(TShopSaleDto tshopSaleDto, String token, long imeiCacheTimeOut) throws ServiceException {
		logger.info(Thread.currentThread().getName()+"*销量上报记录start*："+tshopSaleDto+token);
		if (UtilHelper.isEmpty(token)) {
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_INVALID);
		}
		if (UtilHelper.isEmpty(tshopSaleDto) || UtilHelper.isEmpty(tshopSaleDto.getSaleDate()) 
				|| UtilHelper.isEmpty(tshopSaleDto.gettShopSaleitems())) {
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		String saleDate = tshopSaleDto.getSaleDate();
		List<SaleItem> tShopSaleitem = tshopSaleDto.gettShopSaleitems();
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getShop())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		Integer dealerId = userContext.getShop().getShopId().intValue();
		Integer companyId = userContext.getUser().getCompanyId();
		Integer userId = userContext.getUser().getUserId();
		String werks = userContext.getShop().getWerks();
		if(UtilHelper.isEmpty(userId) || UtilHelper.isEmpty(companyId) 
				|| UtilHelper.isEmpty(dealerId) || UtilHelper.isEmpty(werks)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		List<SalesUploadDto> listSalesUploadDto = new ArrayList<SalesUploadDto>();
		List<SaleItem> listTShopSaleitem = new ArrayList<SaleItem>();
		SalesUploadDto salesUploadDto = null;
		SaleItem saleItem = null;
		ScanValidateDto scan = null;
		List<String> scanImeiList= new ArrayList<String>(); 
		
		Set<String> processList = new HashSet<String>(); 
		for (SaleItem item : tShopSaleitem) {
			String imei = item.getImeiNo();
			if(!CacheUtils.getSupporter().exists(imei)){
//				CacheUtils.getSupporter().set(imei, imei, new Long(60*2));
				CacheUtils.getSupporter().set(imei, imei, imeiCacheTimeOut);
				processList.add(imei);
			}
		}
		for (SaleItem item : tShopSaleitem) {
			String imei = item.getImeiNo();
			/**
			 * 1、品牌为空 
			 */
			if (UtilHelper.isEmpty(item.getBrandCode())) {
				salesUploadDto = new SalesUploadDto();
				salesUploadDto.setStatus(ConstantUtil.STATUS_FOUR);
				salesUploadDto.setId(item.getId());
				salesUploadDto.setImei(imei);
				salesUploadDto.setDay(saleDate);
				listSalesUploadDto.add(salesUploadDto);
				continue;
			}
			//品牌
			String brandCode = item.getBrandCode().toUpperCase();
			/**
			 * 2、品牌是TECNO，并且IMEI为空
			 */
			if (ConstantUtil.BRAN_CODE_LIST.contains(brandCode) && UtilHelper.isEmpty(imei)) {
				logger.debug(Thread.currentThread().getName()+"品牌为TECNO时候，IMEI为空：");
				salesUploadDto = new SalesUploadDto();
				salesUploadDto.setStatus(ConstantUtil.STATUS_FIVE);
				salesUploadDto.setId(item.getId());
				salesUploadDto.setImei(imei);
				salesUploadDto.setDay(saleDate);
				listSalesUploadDto.add(salesUploadDto);
				continue;
			}
			/**
			 * 3、品牌不为空，验证品牌是TECNO的机型，判断前端传入IMEI已经重复。
			 */
			if (ConstantUtil.BRAN_CODE_LIST.contains(brandCode) && !UtilHelper.isEmpty(imei)){
				if(scanImeiList.contains(imei))
				{
					logger.debug(Thread.currentThread().getName()+"前端传入重复IMEI：");
					salesUploadDto = new SalesUploadDto();
					salesUploadDto.setStatus(ConstantUtil.STATUS_SIX);
					salesUploadDto.setId(item.getId());
					salesUploadDto.setImei(imei);
					salesUploadDto.setDay(saleDate);
					listSalesUploadDto.add(salesUploadDto);
					scanImeiList.remove(imei);
					continue;
				}else if(CacheUtils.getSupporter().exists(imei)&&!processList.contains(imei)){
					logger.debug(Thread.currentThread().getName()+"前端传入重复IMEI,来自缓存：");
					salesUploadDto = new SalesUploadDto();
					salesUploadDto.setStatus(ConstantUtil.STATUS_SEVEN);
					salesUploadDto.setId(item.getId());
					salesUploadDto.setImei(imei);
					salesUploadDto.setDay(saleDate);
					listSalesUploadDto.add(salesUploadDto);
					scanImeiList.remove(imei);
					continue;
				}else{
					logger.debug(Thread.currentThread().getName()+"缓存不重复imei：");
					scanImeiList.add(imei);
				}
			}
			/**
			 * 4、品牌不为空，验证品牌是TECNO的机型，将做对IMEI做批量验证重复，是否非法和保存。
			 */
			if (scanImeiList.size()>0 && !UtilHelper.isEmpty(imei)){
				logger.debug(Thread.currentThread().getName()+"非法IMEI：");
				scan = scanValidateManager.scanValidate(imei, null);
				if(UtilHelper.isEmpty(scan.getImeis())){
					salesUploadDto = new SalesUploadDto();
					/**
					 * 4.1、非法的IMEI
					 */
					salesUploadDto.setStatus(ConstantUtil.STATUS_THREE);
				}else{	
					/**
					 * 4.2、判断IMEI是否重复
					 * */
					String imeiOnSql = saleItemMapper.queryScanDuplicatedIMEI(imei);
					List<String> imeiLists = Arrays.asList(scan.getImeis());
					if(scanImeiList.contains(imeiOnSql) || imeiLists.contains(imeiOnSql)){
						logger.debug(Thread.currentThread().getName()+"前端传入IMEI与数据库重复：");
						salesUploadDto = new SalesUploadDto();
						salesUploadDto.setStatus(ConstantUtil.STATUS_TWO);
					}else{
						salesUploadDto = new SalesUploadDto();
						/**
						 * 4.3、保存
						 * */
						salesUploadDto.setStatus(ConstantUtil.STATUS_ONE);
						saleItem = new SaleItem();
						//数据补全
						BeanUtils.copyProperties(item,saleItem);
						saleItem.setBillno(" ");
						saleItem.setCompanyId(companyId);
						saleItem.setLineId(0);
						saleItem.setBrandCode(scan.getBrand());
						saleItem.setModelCode(scan.getModel());
						StringBuilder imeisList = new StringBuilder();
						String [] imeis = scan.getImeis();
						if(!UtilHelper.isEmpty(imeis)){
							for(int i=0;i<imeis.length;i++){
								imeisList.append(imeis[i]+";");
								if(!scanImeiList.contains(imeis[i]))
								{
									scanImeiList.add(imeis[i]);
									//scanImeiList.remove(imei);
								}
							}
						}

						String imeiList = imeisList.toString();
						saleItem.setImeiList(imeiList);
						saleItem.setRemark("ok");
						saleItem.setSaleAmount(item.getSalePrice());
						listTShopSaleitem.add(saleItem);
					}
				}
				
			}
			/**
			 *  5、品牌不为空，验证品牌不是TECNO的机型，直接做保存。
			 */
			if (!ConstantUtil.BRAN_CODE_LIST.contains(brandCode)){
				salesUploadDto = new SalesUploadDto();
				salesUploadDto.setStatus(ConstantUtil.STATUS_ONE);
				saleItem = new SaleItem();
				//数据补全
				BeanUtils.copyProperties(item,saleItem);
				saleItem.setBillno(" ");
				saleItem.setCompanyId(companyId);
				saleItem.setLineId(0);
				saleItem.setRemark("ok");
				saleItem.setSaleAmount(item.getSalePrice());
				listTShopSaleitem.add(saleItem);
			}
			salesUploadDto.setId(item.getId());
			salesUploadDto.setImei(imei);
			salesUploadDto.setDay(saleDate);
			listSalesUploadDto.add(salesUploadDto);

		}
		if (listTShopSaleitem.size() > 0) {
			Sale tShopSales = new Sale();
			tShopSales.setUserId(userId);
			tShopSales.setCompanyId(companyId);
			tShopSales.setShopId(dealerId);
			tShopSales.setBillno(" ");
			tShopSales.setTrantype(24020005);
			tShopSales.setSaleDate(saleDate);
			tShopSales.setStatus(24030005);
			tShopSales.setCreatedBy(userId.toString());
			tShopSales.setCreatedTime(systemDateService.getCurrentDate());
			tShopSales.setUpdatedBy(userId.toString());
			tShopSales.setUpdatedTime(systemDateService.getCurrentDate());
			// 根据店铺ID查询当前最新美元汇率
			java.math.BigDecimal ratio = currencyMapper.queryCurrencyRatio(dealerId,companyId);
			if (!UtilHelper.isEmpty(ratio))
				tShopSales.setCurrencyRatio(ratio);
			tShopSales.setWerks(werks);
			/**
			 * 6、保存主表
			 */
			saleMapper.save(tShopSales);
			int lineId = 1;
			for (int i = 0; i < listTShopSaleitem.size(); i++) {
				listTShopSaleitem.get(i).setSaleId(tShopSales.getId());
				listTShopSaleitem.get(i).setLineId(lineId);
				lineId++;
			}
			/**
			 * 7、保存子表
			 */
			try {
				saleItemMapper.saveSaleItem(listTShopSaleitem);
			} catch (DuplicateKeyException e) {
				logger.error("imei repeat...", e);
				throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
			} catch (DeadlockLoserDataAccessException e) {
				logger.error("imei repeatrollback...", e);
				throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
			}catch (Exception e) {
				logger.error("fail reason...", e);
				throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
			}
		
		}
		logger.info(Thread.currentThread().getName()+"*销量上报记录END*："+listSalesUploadDto);
		return listSalesUploadDto;
	}

	/**
	* 根据订单号删除记录
	* @return
	* @throws ServiceException 
	* 
	*/
	public void deleteByBillNo(String billNo,String token) throws ServiceException
	{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_INVALID);
		}
		if (UtilHelper.isEmpty(billNo))
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext))
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getUser().getUserId())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		SaleItem tShopSaleitem = new SaleItem();
		tShopSaleitem.setBillno(billNo);
		saleItemMapper.deleteByProperty(tShopSaleitem);
		Sale tShopSales = new Sale();
		tShopSales.setUserId(userContext.getUser().getId().intValue());
		tShopSales.setBillno(billNo);
		saleMapper.deleteByProperty(tShopSales);
	}
	
	/**
	 * @see 用户销量数
	 * @author guihua.zhang
	 * @return
	 * @throws ServiceException
	 * */
	public int findSaleQty(String token,String startDate,String endDate) throws ServiceException
	{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_INVALID);
		}
		if(UtilHelper.isEmpty(startDate)||UtilHelper.isEmpty(endDate)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext))
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		Integer userId = userContext.getUser().getId().intValue();
		if(UtilHelper.isEmpty(userId)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		SalesDto salesDto = saleMapper.findSaleQty(userId,startDate,endDate);
		int saleQty= 0;
		if(UtilHelper.isEmpty(salesDto)){
			return saleQty;
		}else{
			saleQty = salesDto.getSaleQty().intValue();
			return saleQty;
		}
	}
	/**
	 * 查询促销员上报销量记录
	 * 
	 * @param token
	 * @param startDate
	 * @param endDate
	 * @param model
	 * @return
	 * @throws ServiceException
	 */
	public List<SalesDto> findPromoterSales(String token, String startDate, String endDate, String model)
			throws ServiceException {
		if(UtilHelper.isEmpty(startDate)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		// 获取token里的用户信息
		Integer userId = userContext.getUser().getId().intValue();
		if(UtilHelper.isEmpty(userId)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		return saleMapper.findPromoterSales(startDate, endDate, model, userId);
	}
}
