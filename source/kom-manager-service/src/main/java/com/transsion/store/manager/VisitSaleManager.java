package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.dto.VisitSaleInfoDto;
import com.transsion.store.mapper.VisitSaleMapper;
import com.transsion.store.utils.ExcelUtils;

@Service("visitSaleManager")
public class VisitSaleManager {
	@Autowired
	private VisitSaleMapper visitSaleMapper;

	public byte[] getVisitSaleByExcel(VisitSaleInfoDto visitSaleInfoDto) throws ServiceException {
		String[] headers = {"序号","巡店单号","事业部","国家","城市","门店代码","门店名称","品牌名称","重点机型","销量","上传用户", "员工姓名",
		"上传时间"};
		List<VisitSaleInfoDto> list = visitSaleMapper.listVisitSaleByProperty(visitSaleInfoDto);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i=1;
		for(VisitSaleInfoDto visitSaleInfoDto1 :list){
			dataset.add(new Object[]{i++,visitSaleInfoDto1.getVisitId(),visitSaleInfoDto1.getCompanyCode(),
							visitSaleInfoDto1.getCountryName(),visitSaleInfoDto1.getCityName(),
							visitSaleInfoDto1.getShopCode(),visitSaleInfoDto1.getShopName(),
							visitSaleInfoDto1.getBrandName(),visitSaleInfoDto1.getModelName(),
							visitSaleInfoDto1.getSaleQty(),visitSaleInfoDto1.getCreateBy(),
							visitSaleInfoDto1.getEmpName(),visitSaleInfoDto1.getCreateTime()});
		}
		String title = "重点机型销量报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
	
	
}
