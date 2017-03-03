package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transsion.store.dto.VisitModelDetailInfoDto;
import com.transsion.store.mapper.VisitModelMapper;
import com.transsion.store.utils.ExcelUtils;

@Service("visitModelManager")
public class VisitModelManager {
	@Autowired
	private VisitModelMapper visitModelMapper;

	public byte[] getVisitModelByExcel(VisitModelDetailInfoDto visitModelDetailInfoDto) {
		String[] headers = {"序号","巡店单号","事业部","国家","城市","门店代码","门店名称","品牌名称","上柜机型","上传用户", "员工姓名",
		"上传时间"};
		List<VisitModelDetailInfoDto> list = visitModelMapper.listVisitModelByProperty(visitModelDetailInfoDto);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i=1;
		for(VisitModelDetailInfoDto visitModelDetailInfoDto1 :list){
			dataset.add(new Object[]{i++,visitModelDetailInfoDto1.getVisitId(),visitModelDetailInfoDto1.getCompanyCode(),
							visitModelDetailInfoDto1.getCountryName(),visitModelDetailInfoDto1.getCityName(),
							visitModelDetailInfoDto1.getShopCode(),visitModelDetailInfoDto1.getShopName(),
							visitModelDetailInfoDto1.getBrandName(),visitModelDetailInfoDto1.getModelName(),
							visitModelDetailInfoDto1.getCreateBy(),visitModelDetailInfoDto1.getEmpName(),
							visitModelDetailInfoDto1.getCreateTime()});
		}
		String title = "上柜机型报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
}
