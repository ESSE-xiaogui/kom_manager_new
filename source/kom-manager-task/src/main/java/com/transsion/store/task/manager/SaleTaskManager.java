package com.transsion.store.task.manager;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Currency;
import com.transsion.store.bo.Sale;
import com.transsion.store.bo.SaleItem;
import com.transsion.store.bo.Shop;
import com.transsion.store.bo.Task;
import com.transsion.store.bo.TaskDetail;
import com.transsion.store.dto.SaleTaskDto;
import com.transsion.store.dto.ScanValidateDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.manager.ScanValidateManager;
import com.transsion.store.mapper.CurrencyMapper;
import com.transsion.store.mapper.SaleItemMapper;
import com.transsion.store.mapper.SaleMapper;
import com.transsion.store.mapper.ShopMapper;
import com.transsion.store.mapper.TaskDetailMapper;
import com.transsion.store.mapper.TaskMapper;
import com.transsion.store.message.Message.Type;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.ExcelUtil;

import net.mikesu.fastdfs.FastdfsClient;
import net.mikesu.fastdfs.FastdfsClientFactory;

@Service("saleTaskManager")
public class SaleTaskManager {
	@Autowired
	private ScanValidateManager scanValidateManager;
	
	@Autowired
	private SaleItemMapper saleItemMapper;
	
	@Autowired
	private ShopMapper shopMapper;
	
	@Autowired
	private SaleMapper saleMapper;
	
	@Autowired
	private SystemDateService systemDateService;
	
	@Autowired
	private TaskDetailMapper taskDetailMapper;
	
	@Autowired
	private TaskMapper taskMapper;
	
	@Autowired
	private CurrencyMapper currencyMapper;
	
	/**
	 * excel解析 转成实体
	 */
	public void getSaleTaskDto(Long taskId) throws ServiceException {
		if(UtilHelper.isEmpty(taskId)){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		Task task = taskMapper.findTaskById(taskId);
		if(UtilHelper.isEmpty(task)){
			throw new ServiceException(ExceptionDef.ERROR_TASK_NONEXIST.getName());
		}
		FastdfsClient fastdfsClient = FastdfsClientFactory.getFastdfsClient();
		InputStream input;
		try {
			input = fastdfsClient.download(task.getUploadPath());
			ExcelUtil e = new ExcelUtil(input);
			String[][] dataArr = e.getData(1);
			if(task.getTaskType().equals(Type.TASK_SALE_IMPORT.getDesc())){
				arrayConvertSaleDto(task,dataArr);
			}else if(task.getTaskType().equals(Type.TASK_CURRENCY_IMPORT.getDesc())){
				arrayConverCurrencyDto(task,dataArr);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * 批量上传销量
	 * */
	public TaskDetail taskSales(SaleTaskDto saleTaskDto) throws ServiceException {
		TaskDetail taskDetail = new TaskDetail();
		/**
		 * imei illeagal
		 */
		ScanValidateDto scan = scanValidateManager.scanValidate(saleTaskDto.getImeiNo(), null);
		if(UtilHelper.isEmpty(scan)){
			taskDetail.setStatus(2);
			taskDetail.setMessage("IMEI illegal");
		}
		if (UtilHelper.isEmpty(scan.getImeis())) {
			taskDetail.setStatus(2);
			taskDetail.setMessage("IMEI illegal");
		} else {
			String imeiNo = saleItemMapper.queryScanDuplicatedIMEI(saleTaskDto.getImeiNo());
			List<String> imeiLists = Arrays.asList(scan.getImeis());
			if (imeiLists.contains(imeiNo)) {
				taskDetail.setStatus(2);
				taskDetail.setMessage("IMEI code repeated");
			} else {
				Sale sale = new Sale();
				sale.setBillno("");
				sale.setUserCode(saleTaskDto.getUserCode());
				Shop shop = new Shop();
				shop = shopMapper.findShopId(saleTaskDto.getShopCode());
				if(UtilHelper.isEmpty(shop)){
					taskDetail.setStatus(2);
					taskDetail.setMessage("shop code is null");
				}else if(UtilHelper.isEmpty(shop.getCompanyId()) || UtilHelper.isEmpty(shop.getShopId())){
					taskDetail.setStatus(2);
					taskDetail.setMessage("shop code is null");
				}else{
				sale.setCompanyId(shop.getCompanyId());
				sale.setShopId(shop.getShopId().intValue());
				sale.setTrantype(24020005);
				sale.setSaleDate(saleTaskDto.getSaleDate());
				sale.setStatus(24030005);
				sale.setWerks("");
				sale.setCurrencyRatio(new BigDecimal("1"));
				saleMapper.save(sale);
				SaleItem saleItem = new SaleItem();
				saleItem.setSaleId(sale.getId());
				saleItem.setCompanyId(shop.getCompanyId());
				saleItem.setBillno("");
				saleItem.setImeiNo(saleTaskDto.getImeiNo());
				saleItem.setBrandCode(scan.getBrand());
				saleItem.setModelCode(scan.getModel());
				saleItem.setLineId(0);
				StringBuilder imeisList = new StringBuilder();
				String[] imeis = scan.getImeis();
				if (!UtilHelper.isEmpty(imeis)) {
					for (int i = 0; i < imeis.length; i++) {
						imeisList.append(imeis[i] + ";");
						/*if (!imeiLists.contains(imeis[i])) {
							imeiLists.add(imeis[i]);
						}*/
					}
				}
				String imeiList = imeisList.toString();
				saleItem.setImeiList(imeiList);
				saleItemMapper.save(saleItem);
				taskDetail.setMessage("ok");
				taskDetail.setStatus(1);
				}
			}
		}
		return taskDetail;
	}
	public void arrayConvertSaleDto(Task task, String[][] dataArr) throws ServiceException{
		TaskDetail taskDetail = new TaskDetail();
		List<Map<String, Object>> list = TaskUtil.formatArr(dataArr,
						new String[] { "Sales date", "Shop ID", "User ID", "IMEI code", "Price" });
		if (UtilHelper.isEmpty(list)) {
			throw new ServiceException(ExceptionDef.ERROR_TASK_FILE_FORMATERROR.getName());
		} else {
			for (Map<String, Object> map : list) {
				SaleTaskDto saleTaskDto = new SaleTaskDto();
				String saleDate = (String) map.get("Sales date");
				String shopCode = (String) map.get("Shop ID");
				String userCode = (String) map.get("User ID");
				String imeiNo = (String) map.get("IMEI code");
				String price = (String) map.get("Price");
				if (UtilHelper.isEmpty(saleDate)) {
					taskDetail.setMessage("Sales date is null");
					taskDetail.setStatus(2);
				}
				if (UtilHelper.isEmpty(shopCode)) {
					taskDetail.setMessage("Shop ID is null");
					taskDetail.setStatus(2);
				}
				if (UtilHelper.isEmpty(userCode)) {
					taskDetail.setMessage("User ID is null");
					taskDetail.setStatus(2);
				}
				if (UtilHelper.isEmpty(imeiNo)) {
					taskDetail.setMessage("IMEI code is null");
					taskDetail.setStatus(2);
				}
				if (UtilHelper.isEmpty(price)) {
					taskDetail.setMessage("Price is null");
					taskDetail.setStatus(2);
				}

				if (!UtilHelper.isEmpty(saleDate) && !UtilHelper.isEmpty(shopCode) && !UtilHelper.isEmpty(userCode)
								&& !UtilHelper.isEmpty(imeiNo) && !UtilHelper.isEmpty(price)) {
					saleTaskDto.setSaleDate(saleDate);
					saleTaskDto.setShopCode(shopCode);
					saleTaskDto.setUserCode(userCode);
					saleTaskDto.setImeiNo(imeiNo);
					BigDecimal bd = new BigDecimal(price);
					saleTaskDto.setPrice(bd);
					taskDetail = this.taskSales(saleTaskDto);
				}

				taskDetail.setTaskId(task.getId());
				String context = "Sales date:" + saleTaskDto.getSaleDate() + "\r" + "Shop ID:"
								+ saleTaskDto.getShopCode() + "\r" + "User ID:" + saleTaskDto.getUserCode() + "\r"
								+ "IMEI code:" + saleTaskDto.getImeiNo() + "\r" + "Price:" + saleTaskDto.getPrice();
				taskDetail.setContext(context);
				taskDetail.setCreateTime(systemDateService.getCurrentDate());
				taskDetailMapper.saveTaskDetail(taskDetail);
			}

		}
	}

	public void arrayConverCurrencyDto(Task task, String[][] dataArr) throws ServiceException{
		TaskDetail taskDetail = new TaskDetail();
		List<Map<String, Object>> list = TaskUtil.formatArr(dataArr,
						new String[] { "国家", "币别编码", "币别名称", "美元兑外币汇率","人民币兑外币汇率","生效日期","失效日期","是否停用" });
		if (UtilHelper.isEmpty(list)) {
			throw new ServiceException(ExceptionDef.ERROR_TASK_FILE_FORMATERROR.getName());
		}else{
			for (Map<String, Object> map : list) {
				Currency currency = new Currency();
				Long country = (Long)map.get("国家");
				String werks = (String)map.get("币别编码");
				String currencyName = (String)map.get("币别名称");
				BigDecimal exchangerate = (BigDecimal)map.get("美元兑外币汇率");
				BigDecimal exchangerate2 = (BigDecimal)map.get("人民币兑外币汇率");
				String beginTime = (String)map.get("生效日期");
				String endTime = (String)map.get("失效日期");
				Integer isInactive = (Integer)map.get("是否停用");
				if (UtilHelper.isEmpty(country)) {
					taskDetail.setMessage("country is null");
				}
				if (UtilHelper.isEmpty(werks)) {
					taskDetail.setMessage("werks is null");
				}
				if (UtilHelper.isEmpty(currencyName)) {
					taskDetail.setMessage("currencyName is null");
				}
				if (UtilHelper.isEmpty(exchangerate)) {
					taskDetail.setMessage("exchangerate is null");
				}
				if (UtilHelper.isEmpty(exchangerate2)) {
					taskDetail.setMessage("exchangerate2 is null");
				}
				if (UtilHelper.isEmpty(beginTime)) {
					taskDetail.setMessage("beginTime is null");
				}
				if (UtilHelper.isEmpty(endTime)) {
					taskDetail.setMessage("endTime is null");
				}
				if (UtilHelper.isEmpty(isInactive)) {
					taskDetail.setMessage("isInactive is null");
				}
				if(!UtilHelper.isEmpty(country) && !UtilHelper.isEmpty(werks)
								&& !UtilHelper.isEmpty(currencyName) && !UtilHelper.isEmpty(exchangerate)
								&& !UtilHelper.isEmpty(exchangerate2) && !UtilHelper.isEmpty(beginTime)
								&& !UtilHelper.isEmpty(endTime) && UtilHelper.isEmpty(isInactive)){
				currency.setCompanyId(1L);
				currency.setFindex(1);
				currency.setRegionId(country);
				currency.setWerks(werks);
				currency.setCurrencyName(currencyName);
				currency.setExchangerate(exchangerate);
				currency.setExchangerate2(exchangerate2);
				currency.setBeginTime(beginTime);
				currency.setEndTime(endTime);
				currency.setIsInactive(isInactive);
				currency.setCreatedBy(task.getUserName());
				currency.setCreatedTime(systemDateService.getCurrentDate());
				currencyMapper.save(currency);
				taskDetail.setMessage("ok");
				}
				taskDetail.setTaskId(task.getId());
				String context = "country:" + country + "\r" + "werks:" + werks + "\r"
								+ "currencyName:" + currencyName + "\r" + "exchangerate:" + exchangerate + 
								"exchangerate2:" + exchangerate2+ "\r" + "beginTime:" + beginTime + "\r" + 
								"endTime:" + endTime + "\r"	+ "isInactive:" + isInactive;
				taskDetail.setContext(context);
				taskDetail.setCreateTime(systemDateService.getCurrentDate());
				taskDetailMapper.saveTaskDetail(taskDetail);
			}
		}
	
	}
}
