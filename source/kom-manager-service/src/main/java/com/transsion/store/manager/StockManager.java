package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Stock;
import com.transsion.store.bo.StockItem;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.StockDto;
import com.transsion.store.dto.StockResponseDto;
import com.transsion.store.mapper.CurrencyMapper;
import com.transsion.store.mapper.StockItemMapper;
import com.transsion.store.mapper.StockMapper;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;

@Service("stockManager")
public class StockManager {
	@Autowired
	private StockMapper stockMapper;
	
	@Autowired
	private StockItemMapper stockItemMapper;
	
	@Autowired
	private SystemDateService systemDateService;
	
	@Autowired
	private CurrencyMapper currencyMapper;
	/**
	 * 保存库存上报记录
	 *
	 * @param StockResponseDto
	 * @return
	 * @throws ServiceException
	 */
	public StockResponseDto saveStockUpload(List<StockDto> stockDtoList, String token) throws ServiceException {
		if (UtilHelper.isEmpty(token)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_INVALID);
		}
		if (UtilHelper.isEmpty(stockDtoList)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
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
		Integer companyId = userContext.getCompanyId().intValue();
		Long dealerId = userContext.getShop().getShopId();
		Long userId = userContext.getUser().getId();
		if(UtilHelper.isEmpty(companyId) || UtilHelper.isEmpty(dealerId) || UtilHelper.isEmpty(userId)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		StockResponseDto stockResponseDto = new StockResponseDto();
		Stock tshopMain = new Stock();
		tshopMain.setStockDate(systemDateService.getCurrentDate());
		tshopMain.setUserId(userId.intValue());
		int count = stockMapper.findByCount(tshopMain);
		if(count>0){
			stockResponseDto.setStatus(2);
		}else{
			Stock shopstockMain = new Stock();
		shopstockMain.setCompanyId(companyId);
		shopstockMain.setShopId(dealerId.intValue());
		shopstockMain.setUserId(userId.intValue());
		shopstockMain.setBillno(" ");
		shopstockMain.setTrantype(24020005);
		shopstockMain.setStatus(24030005);
		String werks = userContext.getShop().getWerks();
		if(!UtilHelper.isEmpty(werks)){
			shopstockMain.setWerks(werks);
		}
		java.math.BigDecimal ratio = currencyMapper.queryCurrencyRatio(dealerId.intValue(),companyId);
		if (!UtilHelper.isEmpty(ratio)){
			shopstockMain.setCurrencyRatio(ratio);
		}
		if (UtilHelper.isEmpty(stockDtoList.get(0).getFdate())) {
			shopstockMain.setStockDate(systemDateService.getCurrentDate());
		} else {
			shopstockMain.setStockDate(stockDtoList.get(0).getFdate());
		}
		shopstockMain.setCreatedBy(userId.toString());
		shopstockMain.setCreatedTime(systemDateService.getCurrentDate());
		shopstockMain.setUpdatedBy(userId.toString());
		shopstockMain.setUpdatedTime(systemDateService.getCurrentDate());
		shopstockMain.setVersion(0);
		stockMapper.save(shopstockMain);
		List<StockItem> stockDetails = new ArrayList<StockItem>();
		int lineId = 1;
		for (StockDto stockDto : stockDtoList) {
			StockItem stockDetail = new StockItem();
			if(!UtilHelper.isEmpty(stockDto.getBrandCode())){
				stockDetail.setBrandCode(stockDto.getBrandCode().toUpperCase());
			}
			String modelCode = stockDto.getModelMatCode();
			stockDetail.setModelCode(modelCode);
			stockDetail.setQty(stockDto.getFqty());
			stockDetail.setPrice(stockDto.getFprice());
			stockDetail.setBillno(" ");
			stockDetail.setCompanyId(companyId);
			stockDetail.setStockId(shopstockMain.getId());
			stockDetail.setLineId(lineId);
			stockItemMapper.updateByHistory(stockDto.getBrandCode().toUpperCase(), modelCode, userId.toString());
			stockDetail.setIshistory(0);
			stockDetails.add(stockDetail);
			lineId++;
		}
		stockItemMapper.saveStockDetailUpload(stockDetails);

		stockResponseDto.setStatus(1);
		}
		return stockResponseDto;		
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
		return stockMapper.findPromoterStock(startDate, endDate, model, userId);
	}

	public List<StockDto> findPromoterCurrentStock(String token) throws ServiceException {
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
		return stockMapper.findPromoterCurrentStock(userId);
	}
	
	public List<StockDto> findStocksByProp(String token, Integer shopId, String startDate, String endDate,
					String model) throws ServiceException {
				validateToken(token);
				if (UtilHelper.isEmpty(startDate)) {
					throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
				}
				UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
				if (UtilHelper.isEmpty(userContext)) {
					throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
				}
				if (UtilHelper.isEmpty(userContext.getUser())) {
					throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
				}
				// 获取token里的用户信息
				Integer userId = userContext.getUser().getUserId();
				if (UtilHelper.isEmpty(userId)) {
					throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
				}
				return stockMapper.findStocksByProp(shopId, startDate, endDate, model, userId);
			}
	
	public List<StockDto> findCurrentStockByProp(String token, Integer shopId) throws ServiceException {
		validateToken(token);
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext)) {
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		if (UtilHelper.isEmpty(userContext.getUser())) {
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		// 获取token里的用户信息
		Integer userId = userContext.getUser().getUserId();
		if (UtilHelper.isEmpty(userId)) {
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		return stockMapper.findCurrentStockByProp(userId, shopId);
	}
	
	public void validateToken(String token) throws ServiceException {
		if (UtilHelper.isEmpty(token)) {
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_USER_INVALID);
		}
	}

}
