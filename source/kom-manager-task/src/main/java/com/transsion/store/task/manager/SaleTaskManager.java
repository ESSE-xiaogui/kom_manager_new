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
import com.transsion.store.bo.Sale;
import com.transsion.store.bo.SaleItem;
import com.transsion.store.bo.Shop;
import com.transsion.store.bo.Task;
import com.transsion.store.bo.TaskDetail;
import com.transsion.store.dto.SaleTaskDto;
import com.transsion.store.dto.ScanValidateDto;
import com.transsion.store.manager.ScanValidateManager;
import com.transsion.store.mapper.SaleItemMapper;
import com.transsion.store.mapper.SaleMapper;
import com.transsion.store.mapper.ShopMapper;
import com.transsion.store.mapper.TaskDetailMapper;
import com.transsion.store.mapper.TaskMapper;
import com.transsion.store.resource.MessageStoreResource;
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
			taskDetail.setMessage("IMEI illegal");
		}
		if (UtilHelper.isEmpty(scan.getImeis())) {
			taskDetail.setMessage("IMEI illegal");
		} else {
			String imeiNo = saleItemMapper.queryScanDuplicatedIMEI(saleTaskDto.getImeiNo());
			List<String> imeiLists = Arrays.asList(scan.getImeis());
			if (imeiLists.contains(imeiNo)) {
				taskDetail.setMessage("IMEI code repeated");
			} else {
				Sale sale = new Sale();
				sale.setBillno("");
				sale.setUserCode(saleTaskDto.getUserCode());
				Shop shop = new Shop();
				shop = shopMapper.findShopId(saleTaskDto.getShopCode());
				if(UtilHelper.isEmpty(shop)){
					taskDetail.setMessage("shop code is null");
				}else if(UtilHelper.isEmpty(shop.getCompanyId()) || UtilHelper.isEmpty(shop.getShopId())){
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
				}
			}
		}
		return taskDetail;
	}

	/**
	 * excel解析 转成实体
	 */
	public void getSaleTaskDto(Long taskId) throws ServiceException {
		if(UtilHelper.isEmpty(taskId)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		Task task = taskMapper.findTaskById(taskId);
		if(UtilHelper.isEmpty(task)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		FastdfsClient fastdfsClient = FastdfsClientFactory.getFastdfsClient();
		InputStream input;
		try {
			input = fastdfsClient.download(task.getUploadPath());
			ExcelUtil e = new ExcelUtil(input);
			String[][] dataArr = e.getData(1);
			TaskDetail taskDetail = new TaskDetail();
			List<Map<String, Object>> list = TaskUtil.formatArr(dataArr,
							new String[] { "Sales date", "Shop ID", "User ID", "IMEI code", "Price" });
			if (UtilHelper.isEmpty(list)) {
				throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_EXCEL_IS_NULL);
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
					}
					if (UtilHelper.isEmpty(shopCode)) {
						taskDetail.setMessage("Shop ID is null");
					}
					if (UtilHelper.isEmpty(userCode)) {
						taskDetail.setMessage("User ID is null");
					}
					if (UtilHelper.isEmpty(imeiNo)) {
						taskDetail.setMessage("IMEI code is null");
					}
					if (UtilHelper.isEmpty(price)) {
						taskDetail.setMessage("Price is null");
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

					taskDetail.setTaskId(taskId);
					String context = "Sales date:" + saleTaskDto.getSaleDate() + "\r" + "Shop ID:"
									+ saleTaskDto.getShopCode() + "\r" + "User ID:" + saleTaskDto.getUserCode() + "\r"
									+ "IMEI code:" + saleTaskDto.getImeiNo() + "\r" + "Price:" + saleTaskDto.getPrice();
					taskDetail.setContext(context);
					taskDetail.setCreateTime(systemDateService.getCurrentDate());
					taskDetailMapper.saveTaskDetail(taskDetail);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
