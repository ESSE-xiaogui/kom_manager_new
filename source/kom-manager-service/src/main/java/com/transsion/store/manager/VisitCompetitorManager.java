package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transsion.store.dto.VisitCompetitorDetailDto;
import com.transsion.store.mapper.VisitCompetitorMapper;
import com.transsion.store.utils.ExcelUtils;

@Service("visitCompetitorManager")
public class VisitCompetitorManager {
	@Autowired
	private VisitCompetitorMapper visitCompetitorMapper;

	/**
	 * 竞品销量
	 * @param vCompetitorDetailDto
	 * @return
	 */
	public byte[] getVisitCompetitorByExcel(VisitCompetitorDetailDto vCompetitorDetailDto) {
		String[] headers = {"序号","巡店单号","事业部","国家","城市","门店代码","门店名称","竞品品牌","销量","上传用户", "员工姓名",
		"上传时间"};
		List<VisitCompetitorDetailDto> list = visitCompetitorMapper.listVisitCompetitorByProperty(vCompetitorDetailDto);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i=1;
		for(VisitCompetitorDetailDto vCompetitorDetailDto1 :list){
			dataset.add(new Object[]{i++,vCompetitorDetailDto1.getVisitId(),vCompetitorDetailDto1.getCompanyCode(),
							vCompetitorDetailDto1.getCountryName(),vCompetitorDetailDto1.getCityName(),
							vCompetitorDetailDto1.getShopCode(),vCompetitorDetailDto1.getShopName(),
							vCompetitorDetailDto1.getBrandName(),vCompetitorDetailDto1.getSaleQty(),
							vCompetitorDetailDto1.getCreateBy(),vCompetitorDetailDto1.getEmpName(),
							vCompetitorDetailDto1.getCreateTime()});
		}
		String title = "竞品销量报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
	
}
