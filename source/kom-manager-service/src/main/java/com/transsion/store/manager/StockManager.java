package com.transsion.store.manager;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch.task.msg.api.ProducerService;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Sale;
import com.transsion.store.bo.SaleItem;
import com.transsion.store.bo.Stock;
import com.transsion.store.bo.StockCurrent;
import com.transsion.store.bo.StockItem;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.SaleDto;
import com.transsion.store.dto.StockDto;
import com.transsion.store.dto.StockInfoDto;
import com.transsion.store.dto.StockResponseDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.CurrencyMapper;
import com.transsion.store.mapper.StockCurrentMapper;
import com.transsion.store.mapper.StockItemMapper;
import com.transsion.store.mapper.StockMapper;
import com.transsion.store.service.StockCurrentService;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;
import com.transsion.store.utils.ExcelUtils;

@Service("stockManager")
public class StockManager {
	Logger logger = LoggerFactory.getLogger(StockManager.class);
	
	private static final String STOCK_UPLOAD_FLAG ="STOCK_UPLOAD_";
	
	private static final long STOCK_UPLOAD_CAHCE_TIME =600;
	
	@Autowired
	private StockMapper stockMapper;
	
	@Autowired
	private StockItemMapper stockItemMapper;
	
	@Autowired
	private SystemDateService systemDateService;
	
	@Autowired
	private CurrencyMapper currencyMapper;
	
	@Autowired
	private StockCurrentService stockCurrentService;
	@Autowired
	private StockCurrentMapper stockCurrentMapper;
	@Autowired
	private ProducerService producerService;
	
	/**
	 * 保存库存上报记录
	 *
	 * @param StockResponseDto
	 * @return
	 * @throws ServiceException
	 */
//	public StockResponseDto saveStockUpload(List<StockDto> stockDtoList, String token) throws ServiceException {
//		if (UtilHelper.isEmpty(token)){
//			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
//		}
//		if (UtilHelper.isEmpty(stockDtoList)){
//			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
//		}
//		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
//		if(UtilHelper.isEmpty(userContext)){
//			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
//		}
//		if(UtilHelper.isEmpty(userContext.getUser())){
//			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
//		}
//		if(UtilHelper.isEmpty(userContext.getShop())){
//			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
//		}
//		Integer companyId = userContext.getCompanyId().intValue();
//		Long dealerId = userContext.getShop().getShopId();
//		Long userId = userContext.getUser().getId();
//		if(UtilHelper.isEmpty(companyId) || UtilHelper.isEmpty(dealerId) || UtilHelper.isEmpty(userId)){
//			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
//		}
//		StockResponseDto stockResponseDto = new StockResponseDto();
//		Stock tshopMain = new Stock();
//		tshopMain.setStockDate(systemDateService.getCurrentDate());
//		tshopMain.setUserId(userId.intValue());
//		int count = stockMapper.findByCount(tshopMain);
//		if(count>0){
//			stockResponseDto.setStatus(2);
//		}else{
//			Stock shopstockMain = new Stock();
//		shopstockMain.setCompanyId(companyId);
//		shopstockMain.setShopId(dealerId.intValue());
//		shopstockMain.setUserId(userId.intValue());
//		shopstockMain.setBillno(" ");
//		shopstockMain.setTrantype(24020005);
//		shopstockMain.setStatus(24030005);
//		String werks = userContext.getShop().getWerks();
//		if(!UtilHelper.isEmpty(werks)){
//			shopstockMain.setWerks(werks);
//		}
//		java.math.BigDecimal ratio = currencyMapper.queryCurrencyRatio(dealerId.intValue(),companyId);
//		if (!UtilHelper.isEmpty(ratio)){
//			shopstockMain.setCurrencyRatio(ratio);
//		}
//		if (UtilHelper.isEmpty(stockDtoList.get(0).getFdate())) {
//			shopstockMain.setStockDate(systemDateService.getCurrentDate());
//		} else {
//			shopstockMain.setStockDate(stockDtoList.get(0).getFdate());
//		}
//		shopstockMain.setCreatedBy(userId.toString());
//		shopstockMain.setCreatedTime(systemDateService.getCurrentDate());
//		shopstockMain.setUpdatedBy(userId.toString());
//		shopstockMain.setUpdatedTime(systemDateService.getCurrentDate());
//		shopstockMain.setVersion(0);
//		stockMapper.save(shopstockMain);
//		List<StockItem> stockDetails = new ArrayList<StockItem>();
//		int lineId = 1;
//		for (StockDto stockDto : stockDtoList) {
//			StockItem stockDetail = new StockItem();
//			if(!UtilHelper.isEmpty(stockDto.getBrandCode())){
//				stockDetail.setBrandCode(stockDto.getBrandCode().toUpperCase());
//			}
//			String modelCode = stockDto.getModelMatCode();
//			stockDetail.setModelCode(modelCode);
//			stockDetail.setQty(stockDto.getFqty());
//			stockDetail.setPrice(stockDto.getFprice());
//			stockDetail.setBillno(" ");
//			stockDetail.setCompanyId(companyId);
//			stockDetail.setStockId(shopstockMain.getId());
//			stockDetail.setLineId(lineId);
//			stockItemMapper.updateByHistory(stockDto.getBrandCode().toUpperCase(), modelCode, userId.toString());
//			stockDetail.setIshistory(1);
//			stockDetails.add(stockDetail);
//			lineId++;
//		}
//		stockItemMapper.saveStockDetailUpload(stockDetails);
//
//		stockResponseDto.setStatus(1);
//		}
//		return stockResponseDto;		
//	}
	
	public StockResponseDto saveStockUpload(List<StockDto> stockDtoList, String token) throws ServiceException {
		long startTime = System.currentTimeMillis();
		logger.info(Thread.currentThread().getName() + "**********************保存库存上报记录start：" + stockDtoList);
		validateToken(token);
		if (UtilHelper.isEmpty(stockDtoList)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		if (UtilHelper.isEmpty(userContext.getUser())) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		if (UtilHelper.isEmpty(userContext.getShop())) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		Integer companyId = userContext.getUser().getCompanyId();
		Integer userId = userContext.getUser().getId().intValue();
		Integer dealerId = stockDtoList.get(0).getDealerId();
		if (UtilHelper.isEmpty(companyId) || UtilHelper.isEmpty(dealerId) || UtilHelper.isEmpty(userId)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		
		// check stock in db
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(new Date());
		StockResponseDto stockResponseDto = new StockResponseDto();
		Stock tshopMain = new Stock();
		tshopMain.setStockDate(systemDateService.getCurrentDate());
		tshopMain.setUserId(userId.intValue());
		
		/*
		 * isValid:从缓存中判断是否重复上传
		 * count:从数据库中判断是否重复上传
		 */
		boolean isValid = isValidStock(tshopMain);
		int count = 0 ;
		if(isValid)
		{
			count = stockMapper.findByCount(tshopMain);
		}
		
		if (!isValid || count > 0) {
			stockResponseDto.setStatus(2);
		} else {
			//remove repeat recode
			//stockDtoList = filterStockDtoList(tshopMain, stockDtoList);
			// not in db
			List<StockItem> stockDetails = new ArrayList<StockItem>();
			int lineId = 1;
			List<StockCurrent> currentStockList = new ArrayList<StockCurrent>();
			for (StockDto stockDto : stockDtoList) {
				StockCurrent tCurrentStock = new StockCurrent();
				tCurrentStock.setBrandCode(stockDto.getBrandCode().toUpperCase());
				tCurrentStock.setModelMatCode(stockDto.getModelMatCode());
				tCurrentStock.setDealerId(dealerId);
				tCurrentStock.setUserId(userId);
				tCurrentStock.setfQty(stockDto.getFqty());
				tCurrentStock.setFdate(dateStr);
				
				List<StockCurrent> list = stockCurrentService.queryByProperty(tCurrentStock);
				if (list != null && list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						if (stockDto.getIsDelete() != null) { // 删除库存
							tCurrentStock.setIsDelete(stockDto.getIsDelete());
							tCurrentStock.setUpdateBy(userId);
							tCurrentStock.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
							stockCurrentService.updateByPorp(tCurrentStock);
						} else {
							tCurrentStock.setIsDelete(0);
							tCurrentStock.setUpdateBy(userId);
							tCurrentStock.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
							stockCurrentService.updateByPorp(tCurrentStock);
						}
					}
				} else {
					if (stockDto.getIsDelete() == null) {
						if (UtilHelper.isEmpty(stockDtoList.get(0).getFdate())) {
							tCurrentStock.setFdate(dateStr);
						} else {
							tCurrentStock.setFdate(stockDtoList.get(0).getFdate());
						}
						tCurrentStock.setIsDelete(0);
						tCurrentStock.setCreateBy(userId);
						tCurrentStock.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
						currentStockList.add(tCurrentStock);
					}
				}
			}
			
			//update stock history
			Stock shopstockMain = new Stock();
			shopstockMain.setCompanyId(companyId);
			shopstockMain.setShopId(dealerId);
			shopstockMain.setUserId(userId);
			shopstockMain.setBillno(" ");
			shopstockMain.setTrantype(24020005);
			shopstockMain.setStatus(24030005);
			String werks = userContext.getShop().getWerks();
			if (!UtilHelper.isEmpty(werks)) {
				shopstockMain.setWerks(werks);
			}
			
			BigDecimal ratio = currencyMapper.queryCurrencyRatio(dealerId.intValue(),companyId);
			if (!UtilHelper.isEmpty(ratio)) {
				shopstockMain.setCurrencyRatio(ratio);
			}
			if (UtilHelper.isEmpty(stockDtoList.get(0).getFdate())) {
				shopstockMain.setStockDate(dateStr);
			} else {
				shopstockMain.setStockDate(stockDtoList.get(0).getFdate());
			}
			shopstockMain.setCreatedBy(userId.toString());
			shopstockMain.setCreatedTime(dateStr);
			shopstockMain.setUpdatedBy(userId.toString());
			shopstockMain.setUpdatedTime(dateStr);
			shopstockMain.setVersion(0);
			//tShopstockMainService.save(shopstockMain);
			
			for (StockDto stockDto : stockDtoList) {
				StockItem stockDetail = new StockItem();
				if (!UtilHelper.isEmpty(stockDto.getBrandCode())) {
					stockDetail.setBrandCode(stockDto.getBrandCode().toUpperCase());
				}
				String modelMatCode = stockDto.getModelMatCode();
				stockDetail.setStockId(shopstockMain.getId());
				stockDetail.setModelCode(modelMatCode);
				stockDetail.setQty(stockDto.getFqty());
				stockDetail.setPrice(stockDto.getFprice());
				stockDetail.setBillno(" ");
				stockDetail.setCompanyId(companyId);
				stockDetail.setStockId(shopstockMain.getId());
				stockDetail.setLineId(lineId);
//				tShopstockDetailService.updateByDealerId(stockDto.getBrandCode().toUpperCase(), modelMatCode,dealerId.toString());
				if (stockDto.getIsDelete() != null) {
					stockDetail.setIshistory(1);
				} else {
					stockDetail.setIshistory(0);
				}
				stockDetails.add(stockDetail);
				lineId++;
			}
//			tShopstockDetailService.saveStockDetailUpload(stockDetails);

			if (currentStockList != null && currentStockList.size() > 0) {
				stockCurrentService.saveTCurrentStockList(currentStockList);
			}
			
			// send message to job
			HashMap<String, Object> messages = new HashMap<String, Object>();
			messages.put("method", "kom.insertShopStock");
			messages.put("stockDetails", stockDetails);
			messages.put("stockMain", shopstockMain);
			logger.info("stockSave  start message...");
//			messageSevice.sendMessages(messages);
			stockResponseDto.setStatus(1);
		}
		logger.info("stockSave end:" + stockResponseDto);
		
		long endTime = System.currentTimeMillis();
		logger.info("upload stock time is:" + (endTime - startTime));
		return stockResponseDto;
	}
	
	/**
	 * 根据销量减库存
	 * @param tshopSaleDto
	 * @param token
	 * @return
	 * @throws ServiceException
	 */
	public void updateCurStockBySale(SaleDto saleDto, String token) throws ServiceException {
		
		/*1.根据sale得到对应的stock，stock减少，时间戳更新stockdate, 
		 * 2.根据 表T_SALE_ITEM: SHOP_ID, BRAND_CODE, MODEL_CODE查询stockcurrent记录
		 * SHOP_IDT_STOCK_CURRENT 表：DEALER_ID， BRAND_CODE， MODEL_MAT_CODE获取
		 * 更新T_STOCK_CURRENT表.发送库存消息
		*/
		
		if (saleDto != null) {
			Sale sale = saleDto.getSale();
			List<SaleItem> shopItems = saleDto.getSaleItems();
			
			if (sale != null && shopItems != null) {
				List<StockCurrent> stockCurrents = new ArrayList<StockCurrent>();
				StockCurrent stockCurrentExp = new StockCurrent();
				stockCurrentExp.setDealerId(sale.getShopId());
				
				stockCurrents = stockCurrentMapper.listByProperty(stockCurrentExp);
				
				for (StockCurrent stockCurrent : stockCurrents) {
					for (SaleItem saleItem :shopItems) {
						// 销量品牌，机型与库存品牌，机型一致，则修改库存
						if (stockCurrent.getBrandCode().equals(saleItem.getBrandCode()) 
								&& stockCurrent.getModelMatCode().equals(saleItem.getModelCode())) {
							stockCurrent.setfQty(stockCurrent.getfQty().subtract(saleItem.getSaleQty()));
						}
					}
					stockCurrent.setUpdateTime(systemDateService.getCurrentDate());
				}

				stockCurrentMapper.batchSaveOrUpdate(stockCurrents);
				/*// 发送消息
				HashMap<String, Object> messages = new HashMap<String, Object>();
				messages.put("method", "kom.updateCurStockBySale");
				messages.put("stockCurrent", stockCurrents);
				logger.info("stockCurrentUpdate  start message...");
				
				TaskMessage msg = new TaskMessage();
				msg.setParams(messages);
				producerService.sendMessage(msg);*/
			}
		}
	}
	
	/**
	 * 查询促销员库存记录
	 * 
	 * @param token
	 * @param startDate
	 * @param endDate
	 * @param model
	 * @return
	 */
	public List<StockDto> findPromoterStock(String token, String startDate, String endDate, String model)
			throws ServiceException {
		if(UtilHelper.isEmpty(startDate)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		// 获取token里的用户信息
		Integer userId = userContext.getUser().getId().intValue();
		if(UtilHelper.isEmpty(userId)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		return stockMapper.findPromoterStock(startDate, endDate, model, userId);
	}

	public List<StockDto> findPromoterCurrentStock(String token) throws ServiceException {
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		// 获取token里的用户信息
		Integer userId = userContext.getUser().getId().intValue();
		if(UtilHelper.isEmpty(userId)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		return stockMapper.findPromoterCurrentStock(userId);
	}
	
	public List<StockDto> findStocksByProp(String token, Integer shopId, String startDate, String endDate,
					String model) throws ServiceException {
				validateToken(token);
				if (UtilHelper.isEmpty(startDate)) {
					throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
				}
				UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
				if (UtilHelper.isEmpty(userContext)) {
					throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
				}
				if (UtilHelper.isEmpty(userContext.getUser())) {
					throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
				}
				// 获取token里的用户信息
				Integer userId = userContext.getUser().getId().intValue();
				if (UtilHelper.isEmpty(userId)) {
					throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
				}
				return stockMapper.findStocksByProp(shopId, startDate, endDate, model, userId);
			}
	
	public List<StockDto> findCurrentStockByProp(String token, Integer shopId) throws ServiceException {
		validateToken(token);
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		if (UtilHelper.isEmpty(userContext.getUser())) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		// 获取token里的用户信息
		Integer userId = userContext.getUser().getId().intValue();
		if (UtilHelper.isEmpty(userId)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		return stockMapper.findCurrentStockByProp(userId, shopId);
	}
	
	public void validateToken(String token) throws ServiceException {
		if (UtilHelper.isEmpty(token)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
	}
	
	
	public byte[] getStockByExcel(StockInfoDto stockInfoDto) throws ServiceException{
		String[] headers = {"序号","单号","库存日期","事业部","品牌","国家","城市","门店名称","机型", "数量",
		"用户名","上传时间"};
		List<StockInfoDto> list = stockMapper.listStockByProperty(stockInfoDto);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i=1;
		for(StockInfoDto stockInfoDto1 :list){
			dataset.add(new Object[]{i++,stockInfoDto1.getBillno(),stockInfoDto1.getStockDate(),
							stockInfoDto1.getCompanyCode(),stockInfoDto1.getBrandCode(),
							stockInfoDto1.getCountryName(),stockInfoDto1.getCityName(),
							stockInfoDto1.getShopName(),stockInfoDto1.getModelCode(),
							stockInfoDto1.getQty(),stockInfoDto1.getUserCode(),
							stockInfoDto1.getCreateTime()});
		}
		String title = "库存报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
	
	/*
	 * 判断是否重复上传
	 */
	public boolean isValidStock(Stock tshopMain) {
		if (tshopMain != null) {
			String date = tshopMain.getStockDate();
			Integer userId = tshopMain.getUserId();
			Integer dealerId = tshopMain.getShopId();
			if (date != null & userId != null && dealerId != null) {
				String id = new StringBuffer(STOCK_UPLOAD_FLAG).append(date).append("_").append(userId).append("_")
						.append(dealerId).toString();
				if (CacheUtils.getSupporter().exists(id)) {
					logger.info(String.format("stock %s already exist", id));
					return false;
				} else {
					CacheUtils.getSupporter().set(id, id, STOCK_UPLOAD_CAHCE_TIME);
				}
			}
		}
		return true;
	}
}
