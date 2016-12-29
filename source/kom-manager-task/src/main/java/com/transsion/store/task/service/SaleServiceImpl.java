package com.transsion.store.task.service;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import com.transsion.store.service.SystemDateService;
import com.transsion.store.task.interfaces.SaleService;
import com.transsion.store.utils.Excel;

@Service("taskSaleService")
public class SaleServiceImpl implements SaleService {
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
	
	/**
	 * 批量上传销量
	 * */
	public void taskSales(List<SaleTaskDto> saleTaskDtoList, Long taskId) throws ServiceException {
		for (SaleTaskDto saleTaskDto : saleTaskDtoList) {
			TaskDetail taskDetail = new TaskDetail();
			/**
			 * param is null
			 */
			if (UtilHelper.isEmpty(saleTaskDto.getImeiNo()) || UtilHelper.isEmpty(saleTaskDto.getUserCode())
							|| UtilHelper.isEmpty(saleTaskDto.getShopCode())) {
				taskDetail.setMessage("IMEI code is null;User ID is null;Shop ID is null");
			}
			/**
			 * imei illeagal
			 */
			ScanValidateDto scan = scanValidateManager.scanValidate(saleTaskDto.getImeiNo(), null);
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
					Shop shop = shopMapper.findShopId(saleTaskDto.getShopCode());
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
					saleItem.setCompanyId(saleTaskDto.getCompanyId());
					saleItem.setBillno("");
					saleItem.setBrandCode(scan.getBrand());
					saleItem.setModelCode(scan.getModel());
					saleItem.setLineId(0);
					StringBuilder imeisList = new StringBuilder();
					String[] imeis = scan.getImeis();
					if (!UtilHelper.isEmpty(imeis)) {
						for (int i = 0; i < imeis.length; i++) {
							imeisList.append(imeis[i] + ";");
							if (!imeiLists.contains(imeis[i])) {
								imeiLists.add(imeis[i]);
							}
						}
					}
					String imeiList = imeisList.toString();
					saleItem.setImeiList(imeiList);
					saleItemMapper.save(saleItem);
					taskDetail.setMessage("IMEI code repeated");
				}
			}
			taskDetail.setTaskId(taskId);
			String constant = saleTaskDto.getSaleDate() + "\r" + saleTaskDto.getShopCode() + "\r"
							+ saleTaskDto.getUserCode() + "\r" + saleTaskDto.getImeiNo() + "\r"
							+ saleTaskDto.getPrice();
			taskDetail.setConstant(constant);
			taskDetail.setCreateTime(systemDateService.getCurrentDate());
			taskDetailMapper.save(taskDetail);
		}
	}
	
	/**
	 * 转换excel
	 * */
	public void getSaleTaskDto(Task task) throws ServiceException {
		if (!UtilHelper.isEmpty(task.getUploadPath())) {
			String uploadPath = task.getUploadPath();
			if (!UtilHelper.isEmpty(uploadPath)) {
				List<SaleTaskDto> saleTaskDtoList = new ArrayList<SaleTaskDto>();
				File file = new File(uploadPath);
				Excel e = new Excel(file);
				String[][] dataArr = e.getData(1);
				//if (dataArr != null && dataArr.length > 0 || (dataArr.length == 1 && dataArr[0].length == 0))
					
				for (int i = 0; i < dataArr.length; i++) {
					SaleTaskDto saleTaskDto = new SaleTaskDto();
					for (int j = 0; j < dataArr[i].length; j++) {
						saleTaskDto.setSaleDate(dataArr[i][0]);
						saleTaskDto.setShopCode(dataArr[i][1]);
						saleTaskDto.setUserCode(dataArr[i][2]);
						saleTaskDto.setImeiNo(dataArr[i][3]);
						saleTaskDto.setPrice(new BigDecimal(dataArr[i][4]));
					}
					saleTaskDtoList.add(saleTaskDto);
				}
				if (!UtilHelper.isEmpty(saleTaskDtoList)) {
					 taskSales(saleTaskDtoList,task.getId());
				}
				
			}
		}
		
	}

}
