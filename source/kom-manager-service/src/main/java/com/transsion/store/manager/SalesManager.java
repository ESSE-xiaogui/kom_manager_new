package com.transsion.store.manager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import com.transsion.store.bo.Employee;
import com.transsion.store.bo.Sale;
import com.transsion.store.bo.SaleItem;
import com.transsion.store.bo.ShopBiz;
import com.transsion.store.bo.ShopGrade;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.SaleDailyDto;
import com.transsion.store.dto.SalesDto;
import com.transsion.store.dto.SalesUploadDto;
import com.transsion.store.dto.StatShopModelSaleDto;
import com.transsion.store.dto.TShopSaleDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.CurrencyMapper;
import com.transsion.store.mapper.EmployeeMapper;
import com.transsion.store.mapper.SaleItemMapper;
import com.transsion.store.mapper.SaleMapper;
import com.transsion.store.mapper.ShopBizMapper;
import com.transsion.store.mapper.ShopGradeMapper;
import com.transsion.store.service.SaleItemService;
import com.transsion.store.utils.CacheUtils;
import com.transsion.store.utils.ExcelUtils;
import com.transsion.store.utils.PropertiesUtils;

@Service("salesMannager")
public class SalesManager {
	Logger logger = LoggerFactory.getLogger(SalesManager.class);
	
	@Autowired
	private SaleMapper saleMapper;
	
	@Autowired
	private SaleItemMapper saleItemMapper;
	
	@Autowired
	private CurrencyMapper currencyMapper;
	
	@Autowired
	private ScanValidateManager scanValidateManager;
	
	@Autowired
	private ShopBizMapper shopBizMapper;
	
	@Autowired
	private ShopGradeMapper shopGradeMapper;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	private SaleItemService saleItemService;
	/**
	 *  销量上报记录
	 * @author guihua.zhang
	 * @return list
	 * @throws ServiceException
	 */
//	public List<SalesUploadDto> saveSalesUpload(TShopSaleDto tshopSaleDto, String token, long imeiCacheTimeOut) throws ServiceException {
//		logger.info(Thread.currentThread().getName()+"*销量上报记录start*："+tshopSaleDto+token);
//		if (UtilHelper.isEmpty(token)) {
//			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
//		}
//		if (UtilHelper.isEmpty(tshopSaleDto) || UtilHelper.isEmpty(tshopSaleDto.getSaleDate()) 
//				|| UtilHelper.isEmpty(tshopSaleDto.gettShopSaleitems())) {
//			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
//		}
//		String saleDate = tshopSaleDto.getSaleDate();
//		List<SaleItem> tShopSaleitem = tshopSaleDto.gettShopSaleitems();
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
//		Integer dealerId = userContext.getShop().getShopId().intValue();
//		Integer companyId = userContext.getUser().getCompanyId();
//		Integer userId = userContext.getUser().getUserId();
//		String werks = userContext.getShop().getWerks();
//		if(UtilHelper.isEmpty(userId) || UtilHelper.isEmpty(companyId) 
//				|| UtilHelper.isEmpty(dealerId) || UtilHelper.isEmpty(werks)){
//			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
//		}
//		List<SalesUploadDto> listSalesUploadDto = new ArrayList<SalesUploadDto>();
//		List<SaleItem> listTShopSaleitem = new ArrayList<SaleItem>();
//		SalesUploadDto salesUploadDto = null;
//		SaleItem saleItem = null;
//		ScanValidateDto scan = null;
//		List<String> scanImeiList= new ArrayList<String>(); 
//		
//		Set<String> processList = new HashSet<String>(); 
//		for (SaleItem item : tShopSaleitem) {
//			String imei = item.getImeiNo();
//			if(!CacheUtils.getSupporter().exists(imei)){
////				CacheUtils.getSupporter().set(imei, imei, new Long(60*2));
//				CacheUtils.getSupporter().set(imei, imei, imeiCacheTimeOut);
//				processList.add(imei);
//			}
//		}
//		for (SaleItem item : tShopSaleitem) {
//			String imei = item.getImeiNo();
//			/**
//			 * 1、品牌为空 
//			 */
//			if (UtilHelper.isEmpty(item.getBrandCode())) {
//				salesUploadDto = new SalesUploadDto();
//				salesUploadDto.setStatus(ConstantUtil.STATUS_FOUR);
//				salesUploadDto.setId(item.getId());
//				salesUploadDto.setImei(imei);
//				salesUploadDto.setDay(saleDate);
//				listSalesUploadDto.add(salesUploadDto);
//				continue;
//			}
//			//品牌
//			String brandCode = item.getBrandCode().toUpperCase();
//			/**
//			 * 2、品牌是TECNO，并且IMEI为空
//			 */
//			if (ConstantUtil.BRAN_CODE_LIST.contains(brandCode) && UtilHelper.isEmpty(imei)) {
//				logger.debug(Thread.currentThread().getName()+"品牌为TECNO时候，IMEI为空：");
//				salesUploadDto = new SalesUploadDto();
//				salesUploadDto.setStatus(ConstantUtil.STATUS_FIVE);
//				salesUploadDto.setId(item.getId());
//				salesUploadDto.setImei(imei);
//				salesUploadDto.setDay(saleDate);
//				listSalesUploadDto.add(salesUploadDto);
//				continue;
//			}
//			/**
//			 * 3、品牌不为空，验证品牌是TECNO的机型，判断前端传入IMEI已经重复。
//			 */
//			if (ConstantUtil.BRAN_CODE_LIST.contains(brandCode) && !UtilHelper.isEmpty(imei)){
//				if(scanImeiList.contains(imei))
//				{
//					logger.debug(Thread.currentThread().getName()+"前端传入重复IMEI：");
//					salesUploadDto = new SalesUploadDto();
//					salesUploadDto.setStatus(ConstantUtil.STATUS_SIX);
//					salesUploadDto.setId(item.getId());
//					salesUploadDto.setImei(imei);
//					salesUploadDto.setDay(saleDate);
//					listSalesUploadDto.add(salesUploadDto);
//					scanImeiList.remove(imei);
//					continue;
//				}else if(CacheUtils.getSupporter().exists(imei)&&!processList.contains(imei)){
//					logger.debug(Thread.currentThread().getName()+"前端传入重复IMEI,来自缓存：");
//					salesUploadDto = new SalesUploadDto();
//					salesUploadDto.setStatus(ConstantUtil.STATUS_SEVEN);
//					salesUploadDto.setId(item.getId());
//					salesUploadDto.setImei(imei);
//					salesUploadDto.setDay(saleDate);
//					listSalesUploadDto.add(salesUploadDto);
//					scanImeiList.remove(imei);
//					continue;
//				}else{
//					logger.debug(Thread.currentThread().getName()+"缓存不重复imei：");
//					scanImeiList.add(imei);
//				}
//			}
//			/**
//			 * 4、品牌不为空，验证品牌是TECNO的机型，将做对IMEI做批量验证重复，是否非法和保存。
//			 */
//			if (scanImeiList.size()>0 && !UtilHelper.isEmpty(imei)){
//				logger.debug(Thread.currentThread().getName()+"非法IMEI：");
//				scan = scanValidateManager.scanValidate(imei, null);
//				if(UtilHelper.isEmpty(scan.getImeis())){
//					salesUploadDto = new SalesUploadDto();
//					/**
//					 * 4.1、非法的IMEI
//					 */
//					salesUploadDto.setStatus(ConstantUtil.STATUS_THREE);
//				}else{	
//					/**
//					 * 4.2、判断IMEI是否重复
//					 * */
//					String imeiOnSql = saleItemMapper.queryScanDuplicatedIMEI(imei);
//					List<String> imeiLists = Arrays.asList(scan.getImeis());
//					if(scanImeiList.contains(imeiOnSql) || imeiLists.contains(imeiOnSql)){
//						logger.debug(Thread.currentThread().getName()+"前端传入IMEI与数据库重复：");
//						salesUploadDto = new SalesUploadDto();
//						salesUploadDto.setStatus(ConstantUtil.STATUS_TWO);
//					}else{
//						salesUploadDto = new SalesUploadDto();
//						/**
//						 * 4.3、保存
//						 * */
//						salesUploadDto.setStatus(ConstantUtil.STATUS_ONE);
//						saleItem = new SaleItem();
//						//数据补全
//						BeanUtils.copyProperties(item,saleItem);
//						saleItem.setBillno(" ");
//						saleItem.setCompanyId(companyId);
//						saleItem.setLineId(0);
//						saleItem.setBrandCode(scan.getBrand());
//						saleItem.setModelCode(scan.getModel());
//						StringBuilder imeisList = new StringBuilder();
//						String [] imeis = scan.getImeis();
//						if(!UtilHelper.isEmpty(imeis)){
//							for(int i=0;i<imeis.length;i++){
//								imeisList.append(imeis[i]+";");
//								if(!scanImeiList.contains(imeis[i]))
//								{
//									scanImeiList.add(imeis[i]);
//									//scanImeiList.remove(imei);
//								}
//							}
//						}
//
//						String imeiList = imeisList.toString();
//						saleItem.setImeiList(imeiList);
//						saleItem.setRemark("ok");
//						saleItem.setSaleAmount(item.getSalePrice());
//						listTShopSaleitem.add(saleItem);
//					}
//				}
//				
//			}
//			/**
//			 *  5、品牌不为空，验证品牌不是TECNO的机型，直接做保存。
//			 */
//			if (!ConstantUtil.BRAN_CODE_LIST.contains(brandCode)){
//				salesUploadDto = new SalesUploadDto();
//				salesUploadDto.setStatus(ConstantUtil.STATUS_ONE);
//				saleItem = new SaleItem();
//				//数据补全
//				BeanUtils.copyProperties(item,saleItem);
//				saleItem.setBillno(" ");
//				saleItem.setCompanyId(companyId);
//				saleItem.setLineId(0);
//				saleItem.setRemark("ok");
//				saleItem.setSaleAmount(item.getSalePrice());
//				listTShopSaleitem.add(saleItem);
//			}
//			salesUploadDto.setId(item.getId());
//			salesUploadDto.setImei(imei);
//			salesUploadDto.setDay(saleDate);
//			listSalesUploadDto.add(salesUploadDto);
//
//		}
//		if (listTShopSaleitem.size() > 0) {
//			Sale tShopSales = new Sale();
//			tShopSales.setUserId(userId);
//			tShopSales.setCompanyId(companyId);
//			tShopSales.setShopId(dealerId);
//			tShopSales.setBillno(" ");
//			tShopSales.setTrantype(24020005);
//			tShopSales.setSaleDate(saleDate);
//			tShopSales.setStatus(24030005);
//			tShopSales.setCreatedBy(userId.toString());
//			tShopSales.setCreatedTime(systemDateService.getCurrentDate());
//			tShopSales.setUpdatedBy(userId.toString());
//			tShopSales.setUpdatedTime(systemDateService.getCurrentDate());
//			// 根据店铺ID查询当前最新美元汇率
//			java.math.BigDecimal ratio = currencyMapper.queryCurrencyRatio(dealerId,companyId);
//			if (!UtilHelper.isEmpty(ratio))
//				tShopSales.setCurrencyRatio(ratio);
//			tShopSales.setWerks(werks);
//			/**
//			 * 6、保存主表
//			 */
//			saleMapper.save(tShopSales);
//			int lineId = 1;
//			for (int i = 0; i < listTShopSaleitem.size(); i++) {
//				listTShopSaleitem.get(i).setSaleId(tShopSales.getId());
//				listTShopSaleitem.get(i).setLineId(lineId);
//				lineId++;
//			}
//			/**
//			 * 7、保存子表
//			 */
//			try {
//				saleItemMapper.saveSaleItem(listTShopSaleitem);
//			} catch (DuplicateKeyException e) {
//				logger.error("imei repeat...", e);
//				throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
//			} catch (DeadlockLoserDataAccessException e) {
//				logger.error("imei repeatrollback...", e);
//				throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
//			}catch (Exception e) {
//				logger.error("fail reason...", e);
//				throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
//			}
//		
//		}
//		logger.info(Thread.currentThread().getName()+"*销量上报记录END*："+listSalesUploadDto);
//		return listSalesUploadDto;
//	}
	
	
	/**
	 * 销量上传
	 * 
	 * @param tshopSaleDto
	 * @param token
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<SalesUploadDto> saveSalesUpload(TShopSaleDto tshopSaleDto, String token) throws ServiceException {
		long startTime = System.currentTimeMillis();
		logger.info(Thread.currentThread().getName() + "*upload sales start*：" + tshopSaleDto + token);

		if (UtilHelper.isEmpty(token)) {
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		// 判断当前用户的用户信息及用户店铺信息
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

		// 判断入参是否为空
		String saleDate = tshopSaleDto.getSaleDate();
		List<SaleItem> inputShopSaleItemList = tshopSaleDto.gettShopSaleitems();
		if (UtilHelper.isEmpty(tshopSaleDto) || UtilHelper.isEmpty(saleDate)
				|| UtilHelper.isEmpty(inputShopSaleItemList)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}

		Integer dealerId = tshopSaleDto.getDealerId();
		Integer companyId = userContext.getUser().getCompanyId();
		Integer userId = userContext.getUser().getId().intValue();
		String werks = userContext.getShop().getWerks();
		if (UtilHelper.isEmpty(userId) || UtilHelper.isEmpty(companyId) || UtilHelper.isEmpty(dealerId)
				|| UtilHelper.isEmpty(werks)) {
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}

		// 出参列表
		List<SalesUploadDto> saleUploadRespList = new ArrayList<SalesUploadDto>();
		List<SaleItem> listTShopSaleitem = new ArrayList<SaleItem>();
		SaleItem saleItem = null;

		// 查询imei是否在缓存中的超时时间
		long cacheImeiStartTime = System.currentTimeMillis();
		Set<String> processList = new HashSet<String>();
		long imeiCacheTime = 600;
		try {
			imeiCacheTime = Long.valueOf(PropertiesUtils.readProperties("imei.cache.timeout"));
		} catch (Exception e) {
			logger.error("read cache properties error:", e);
		}

		Iterator<SaleItem> inputSaleItemItor = inputShopSaleItemList.iterator();
		while (inputSaleItemItor.hasNext()) {
			SaleItem inputSaleItem = inputSaleItemItor.next();
			String inputImei = inputSaleItem.getImeiNo();
			String brandCode = inputSaleItem.getBrandCode().toUpperCase();

			SalesUploadDto salesUploadDto = new SalesUploadDto();
			salesUploadDto.setId(inputSaleItem.getId());
			salesUploadDto.setImei(inputImei);
			salesUploadDto.setDay(saleDate);
			salesUploadDto.setDealerId(dealerId);

			// check brand code
			if (UtilHelper.isEmpty(brandCode)) {
				logger.debug(Thread.currentThread().getName() + "brand code is null...");
				salesUploadDto.setStatus(ConstantUtil.STATUS_FOUR);
				saleUploadRespList.add(salesUploadDto);
				inputSaleItemItor.remove();
				continue;
			}

			// check brand code and imei
			if (ConstantUtil.BRAN_CODE_LIST.contains(brandCode) && UtilHelper.isEmpty(inputImei)) {
				logger.debug(Thread.currentThread().getName() + "brand code is TECNO, but imei is null...");
				salesUploadDto.setStatus(ConstantUtil.STATUS_FIVE);
				saleUploadRespList.add(salesUploadDto);
				inputSaleItemItor.remove();
				continue;
			}

			// check brand code is TECNO and imei is repeate
			if (ConstantUtil.BRAN_CODE_LIST.contains(brandCode) && !UtilHelper.isEmpty(inputImei)) {
				if (processList.contains(inputImei)) {
					logger.debug(Thread.currentThread().getName() + "imei in processList...");
					salesUploadDto.setStatus(ConstantUtil.STATUS_SIX);
					saleUploadRespList.add(salesUploadDto);
					inputSaleItemItor.remove();
					continue;
				} else if (CacheUtils.getSupporter().exists(inputImei) && !processList.contains(inputImei)) {
					logger.debug(Thread.currentThread().getName() + " imei in cache...");
					salesUploadDto.setStatus(ConstantUtil.STATUS_SEVEN);
					saleUploadRespList.add(salesUploadDto);
					inputSaleItemItor.remove();
					continue;
				} else if (!CacheUtils.getSupporter().exists(inputImei)) {
					logger.debug(Thread.currentThread().getName() + "imei not in cache...");
					CacheUtils.getSupporter().set(inputImei, inputImei, imeiCacheTime);
					processList.add(inputImei);
				}
			}
		}
		long cacheImeiEndTime = System.currentTimeMillis();
		logger.debug("check imei in cache time is:" + (cacheImeiEndTime - cacheImeiStartTime));
		
		long scanImeiStartTime = System.currentTimeMillis();
		inputSaleItemItor = inputShopSaleItemList.iterator();
		StringBuilder imeiBuilder = new StringBuilder();
		while (inputSaleItemItor.hasNext()) {
			SaleItem inputSaleItem = inputSaleItemItor.next();
			String inputImei = inputSaleItem.getImeiNo();
			if (!UtilHelper.isEmpty(inputImei)) {
				imeiBuilder.append(inputImei).append(";");
			}
		}
		if (imeiBuilder.toString().endsWith(";")) {
			imeiBuilder.deleteCharAt(imeiBuilder.length() - 1);
		}

		// 批量验证imei
		List<LinkedHashMap> scanImeiMap = scanValidateManager.scanValidateBatch(imeiBuilder.toString());
		inputSaleItemItor = inputShopSaleItemList.iterator();
		List<String> checkDbImeiList = new ArrayList<String>();

		Map<String, List<String>> imeiListMap = new HashMap<String, List<String>>();
		while (inputSaleItemItor.hasNext()) {
			SaleItem inputSaleItem = inputSaleItemItor.next();
			String inputImei = inputSaleItem.getImeiNo();
			if (!UtilHelper.isEmpty(inputImei)) {
				for (LinkedHashMap imeiResultMap : scanImeiMap) {
					String scanImei = (String) imeiResultMap.get("imei1");
					if (inputImei.equals(scanImei)) {
						Map imeisMap = (Map) imeiResultMap.get("kom");
						if (imeisMap != null) {
							List<String> imeList = (List<String>) imeisMap.get("imeis");
							checkDbImeiList.addAll(imeList);
							imeiListMap.put(scanImei, imeList);
						} else {
							SalesUploadDto salesUploadDto = new SalesUploadDto();
							salesUploadDto.setId(inputSaleItem.getId());
							salesUploadDto.setImei(inputImei);
							salesUploadDto.setDay(saleDate);
							salesUploadDto.setDealerId(dealerId);
							salesUploadDto.setStatus(ConstantUtil.STATUS_THREE);
							saleUploadRespList.add(salesUploadDto);
							inputSaleItemItor.remove();
							imeiListMap.remove(scanImei);
							continue;
						}
						break;
					}
				}
			}
		}
		long scanImeiEndTime = System.currentTimeMillis();
		logger.debug("check imei in scan time is:" + (scanImeiEndTime - scanImeiStartTime));
		
		long dbImeiStartTime = System.currentTimeMillis();
		if (checkDbImeiList != null && checkDbImeiList.size() > 0) {
			List<String> dbImeiList = saleItemService.queryImeiNoList(checkDbImeiList);
			inputSaleItemItor = inputShopSaleItemList.iterator();
			while (inputSaleItemItor.hasNext()) {
				SaleItem inputSaleItem = inputSaleItemItor.next();
				String inputImei = inputSaleItem.getImeiNo();
				if (!UtilHelper.isEmpty(inputImei)) {
					for (String dbImei : dbImeiList) {
						SalesUploadDto salesUploadDto = new SalesUploadDto();
						salesUploadDto.setId(inputSaleItem.getId());
						salesUploadDto.setImei(inputImei);
						salesUploadDto.setDay(saleDate);
						salesUploadDto.setDealerId(dealerId);
						if (inputImei.equals(dbImei)) {
							salesUploadDto.setStatus(ConstantUtil.STATUS_TWO);
							saleUploadRespList.add(salesUploadDto);
							inputSaleItemItor.remove();
							continue;
						} 
					}
				}
			}
			long dbImeiEndTime = System.currentTimeMillis();
			logger.debug("check imei in db time is:" + (dbImeiEndTime - dbImeiStartTime));
		}
		
		inputSaleItemItor = inputShopSaleItemList.iterator();
		while (inputSaleItemItor.hasNext()) {
			SaleItem inputSaleItem = inputSaleItemItor.next();
			String inputImei = inputSaleItem.getImeiNo();
			if (!UtilHelper.isEmpty(inputImei)) {
				saleItem = new SaleItem();
				// 数据补全
				BeanUtils.copyProperties(inputSaleItem, saleItem);
				saleItem.setBillno(" ");
				saleItem.setCompanyId(companyId);
				saleItem.setLineId(0);
				saleItem.setBrandCode(inputSaleItem.getBrandCode());
//				saleItem.setModelMatCode(inputSaleItem.getModelMatCode());
				saleItem.setModelCode(inputSaleItem.getModelCode());

				List<String> imeiList = imeiListMap.get(inputImei);
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < imeiList.size(); i++) {
					sb.append(imeiList.get(i)).append(";");
				}

				saleItem.setImeiList(sb.toString());
//				saleItem.setMessagetxt("ok");
				saleItem.setRemark("ok");
				saleItem.setSaleAmount(inputSaleItem.getSalePrice());
				listTShopSaleitem.add(saleItem);
				
				SalesUploadDto salesUploadDto = new SalesUploadDto();
				salesUploadDto.setStatus(ConstantUtil.STATUS_ONE);
				salesUploadDto.setId(inputSaleItem.getId());
				salesUploadDto.setImei(inputImei);
				salesUploadDto.setDay(saleDate);
				salesUploadDto.setDealerId(dealerId);
				saleUploadRespList.add(salesUploadDto);
			}
		}

		if (listTShopSaleitem.size() > 0)
		{
			long saveStartTime = System.currentTimeMillis();
			Sale tShopSales = new Sale();
//			tShopSales.setEmpId(userId);
			tShopSales.setUserId(userId);
			tShopSales.setCompanyId(companyId);
//			tShopSales.setDealerId(dealerId);
			tShopSales.setShopId(dealerId);
			tShopSales.setBillno(" ");
			tShopSales.setTrantype(24020005);
			tShopSales.setSaleDate(saleDate);
//			tShopSales.setFstatus(24030005);
			tShopSales.setStatus(24030005);
			tShopSales.setCreatedBy(userId.toString());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = df.format(new Date());
			tShopSales.setCreatedTime(date);
			tShopSales.setUpdatedBy(userId.toString());
			tShopSales.setUpdatedTime(date);
			// 根据店铺ID查询当前最新美元汇率
			java.math.BigDecimal ratio = currencyMapper.queryCurrencyRatio(dealerId, companyId);
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
				throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
			} catch (DeadlockLoserDataAccessException e) {
				logger.error("imei repeatrollback...", e);
				throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
			} catch (Exception e) {
				logger.error("fail reason...", e);
				throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
			}
			long saveEndTime = System.currentTimeMillis();
			logger.debug("save data to database time is:" + (saveEndTime - saveStartTime));

			/**
			 * 8、发送MQ
			 */
			long mqStartTime = System.currentTimeMillis();
			HashMap<String, Object> messages = new HashMap<String, Object>();
			messages.put("method", "kom.insertShopSale");
			messages.put("shopSaleItem", listTShopSaleitem);
			messages.put("shopSales", tShopSales);
			logger.info("salesSaveUpload  start message...");
//			messageSevice.sendMessages(messages);
			long mqEndTime = System.currentTimeMillis();
			logger.debug("send mq message time is:" + (mqEndTime - mqStartTime));
		}

		for (String imei : processList) {
			CacheUtils.getSupporter().remove(imei);
		}

		logger.info(Thread.currentThread().getName() + "*sale upload end*：" + saleUploadRespList);
		long endTime = System.currentTimeMillis();
		logger.debug("sales upload time is:" + (endTime - startTime));
		return saleUploadRespList;
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
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if (UtilHelper.isEmpty(billNo))
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		UserContext userContext = (UserContext) CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext))
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		if(UtilHelper.isEmpty(userContext.getUser().getUserId())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
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
	 *  用户销量数
	 * @author guihua.zhang
	 * @return
	 * @throws ServiceException
	 * */
	public int findSaleQty(String token,String startDate,String endDate) throws ServiceException
	{
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		if(UtilHelper.isEmpty(startDate)||UtilHelper.isEmpty(endDate)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if (UtilHelper.isEmpty(userContext))
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		if(UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		Integer userId = userContext.getUser().getId().intValue();
		if(UtilHelper.isEmpty(userId)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
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
		return saleMapper.findPromoterSales(startDate, endDate, model, userId);
	}
	public SaleDailyDto findSaleItem(Long saleId) throws ServiceException{
		if(UtilHelper.isEmpty(saleId)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		SaleDailyDto sdDto = new SaleDailyDto();
		ShopBiz shopBiz = shopBizMapper.findShopBiz(saleId);
		if(UtilHelper.isEmpty(shopBiz)){
			sdDto.setBizName(null);
		}else{
		sdDto.setBizName(shopBiz.getBizName());
		}
		ShopGrade shopGrade = shopGradeMapper.findShopGrade(saleId);
		if(UtilHelper.isEmpty(shopGrade)){
			sdDto.setGradeName(null);
		}else{
		sdDto.setGradeName(shopGrade.getGradeName());
		}
		Employee employee = employeeMapper.findEmployee(saleId);
		if(UtilHelper.isEmpty(employee)){
			sdDto.setEmpName(null);
			sdDto.setNation(null);
		}else{
		sdDto.setEmpName(employee.getEmpName());
		sdDto.setNation(employee.getNation());
		}
		return sdDto;
	}
	/**
	 * 销量导出Excel
	 * @param saleDailyDto 
	 * @return
	 * @throws ServiceException
	 */
	public byte[] getSaleByExcel(SaleDailyDto saleDailyDto, String token) throws ServiceException {
		String[] headers = {"序号","单号","销售日期","国家","城市","门店名称","品牌", "机型",
		"IMEI号","IMEI List","数量","价格","当前汇率","用户名","上传时间"};
		List<SaleDailyDto> list = saleMapper.listSaleByProperty(saleDailyDto);
//		if(list.size()>65536){
//			throw new ServiceException(ExceptionDef.ERROR_SALE_TOO_MANY_RESULTS.getName());
//		}
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i=1;
		for(SaleDailyDto saleDailyDto1 :list){
			dataset.add(new Object[]{i++,saleDailyDto1.getBillNo(),saleDailyDto1.getSaleDate(),saleDailyDto1.getCountryName(),
							saleDailyDto1.getCityName(),saleDailyDto1.getShopName(),saleDailyDto1.getBrandCode(),
							saleDailyDto1.getModelCode(),saleDailyDto1.getImeiNo(),saleDailyDto1.getImeiList(),
							saleDailyDto1.getSaleQty(),saleDailyDto1.getSalePrice(),saleDailyDto1.getCurrencyRatio(),
							saleDailyDto1.getUserName(),saleDailyDto1.getCreatedTime()});
		}
		String title = "销量报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
	
	
	/**
	 *  店铺销量统计
	 * @return
	 * @throws ServiceException
	 * */
	public long calcShopSaleQty(long shopId,String startDate,String endDate) throws ServiceException
	{
		return -1;
	}
	
	/**
	 *  店铺机型销量统计
	 * @return
	 * @throws ServiceException
	 * */
	public List<StatShopModelSaleDto> calcShopModelSaleQty(long shopId, List<String> modelCodeList, String startDate,String endDate) throws ServiceException
	{
		return null;
	}
	
}
