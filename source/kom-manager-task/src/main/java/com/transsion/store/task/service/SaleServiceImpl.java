package com.transsion.store.task.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Sale;
import com.transsion.store.bo.SaleItem;
import com.transsion.store.bo.Shop;
import com.transsion.store.dto.SaleTaskDto;
import com.transsion.store.dto.ScanValidateDto;
import com.transsion.store.manager.ScanValidateManager;
import com.transsion.store.mapper.SaleItemMapper;
import com.transsion.store.mapper.SaleMapper;
import com.transsion.store.mapper.ShopMapper;
import com.transsion.store.task.interfaces.SaleService;

public class SaleServiceImpl implements SaleService {
	@Autowired
	private ScanValidateManager scanValidateManager;
	
	@Autowired
	private SaleItemMapper saleItemMapper;
	
	@Autowired
	private ShopMapper shopMapper;
	
	@Autowired
	private SaleMapper saleMapper;
	/**
	 * 批量上传销量
	 * */
	public List<SaleTaskDto> taskSales(List<SaleTaskDto> saleTaskDtoList) throws ServiceException {
		List<SaleTaskDto> saleList = new ArrayList<SaleTaskDto>();
		for(SaleTaskDto saleTaskDto:saleTaskDtoList){
			SaleTaskDto s = new SaleTaskDto();
			BeanUtils.copyProperties(saleTaskDto, s);
			//param is null
			if(UtilHelper.isEmpty(saleTaskDto.getImeiNo()) || UtilHelper.isEmpty(saleTaskDto.getUserCode())
					|| UtilHelper.isEmpty(saleTaskDto.getShopCode())){
				
				s.setRemark("IMEI code is null;User ID is null;Shop ID is null");
			}
			//imei illeagal
			ScanValidateDto scan =  scanValidateManager.scanValidate(saleTaskDto.getImeiNo(), null);
			if(UtilHelper.isEmpty(scan.getImeis())){
				s.setRemark("IMEI illegal");
			}else{
			String imeiNo =	saleItemMapper.queryScanDuplicatedIMEI(saleTaskDto.getImeiNo());
			List<String> imeiLists = Arrays.asList(scan.getImeis());
			if(imeiLists.contains(imeiNo)){
				s.setRemark("IMEI code repeated");
			}else{
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
				String [] imeis = scan.getImeis();
				if(!UtilHelper.isEmpty(imeis)){
					for(int i=0;i<imeis.length;i++){
						imeisList.append(imeis[i]+";");
						if(!imeiLists.contains(imeis[i]))
						{
							imeiLists.add(imeis[i]);
							//scanImeiList.remove(imei);
						}
					}
				}
				String imeiList = imeisList.toString();
				saleItem.setImeiList(imeiList);
				saleItemMapper.save(saleItem);
			}
			}		
			saleList.add(saleTaskDto);
		}
		return saleList;
	}

}
