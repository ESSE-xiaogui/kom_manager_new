package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.dto.VisitStockDetailDto;
import com.transsion.store.mapper.VisitStockMapper;
import com.transsion.store.utils.ExcelUtils;

@Service("visitStockManager")
public class VisitStockManager {
	@Autowired
	private VisitStockMapper visitStockMapper;

	
	public byte[] getVisitStockByExcel(VisitStockDetailDto visitStockDetailDto) throws ServiceException {
		String[] headers = {"序号","巡店单号","事业部","国家","城市","门店代码","门店名称","上传用户", "员工姓名",
		"重点机型","库存数量","前四周平均销量","剩余库存周转周数","上传时间"};
		List<VisitStockDetailDto> list = visitStockMapper.listVisitStockByProperty(visitStockDetailDto);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i=1;
		for(VisitStockDetailDto visitStockDetailDto1 :list){
			dataset.add(new Object[]{i++,visitStockDetailDto1.getVisitId(),visitStockDetailDto1.getCompanyCode(),
							visitStockDetailDto1.getCountryName(),visitStockDetailDto1.getCityName(),
							visitStockDetailDto1.getShopCode(),visitStockDetailDto1.getShopName(),
							visitStockDetailDto1.getCreateBy(),visitStockDetailDto1.getEmpName(),
							visitStockDetailDto1.getModelName(),visitStockDetailDto1.getStockQty(),
							visitStockDetailDto1.getSaleAvg(),visitStockDetailDto1.getStockIto(),
							visitStockDetailDto1.getCreateTime()});
		}
		String title = "重点机型库存报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}

}
