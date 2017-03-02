package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.dto.VisitScoreDetailInfoDto;
import com.transsion.store.mapper.VisitScoreMapper;
import com.transsion.store.utils.ExcelUtils;

@Service("visitScoreManager")
public class VisitScoreManager {
	@Autowired
	private VisitScoreMapper visitScoreMapper;

	/**
	 * 巡店打分导出Excel
	 * @param visitScoreDetailInfoDto
	 * @return
	 * @throws ServiceException 
	 */
	public byte[] getVisitScoreByExcel(VisitScoreDetailInfoDto visitScoreDetailInfoDto) throws ServiceException {
		String[] headers = {"序号","巡店单号","事业部","国家","城市","门店代码","门店名称","门店形象","业务技能","人员形象","合计得分","上传用户", "员工姓名",
		"上传时间"};
		List<VisitScoreDetailInfoDto> list = visitScoreMapper.listVisitScoreByProperty(visitScoreDetailInfoDto);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i=1;
		for(VisitScoreDetailInfoDto visitScoreDetailInfoDto1 :list){
			dataset.add(new Object[]{i++,visitScoreDetailInfoDto1.getVisitId(),visitScoreDetailInfoDto1.getCompanyCode(),
							visitScoreDetailInfoDto1.getCountryName(),visitScoreDetailInfoDto1.getCityName(),
							visitScoreDetailInfoDto1.getShopCode(),visitScoreDetailInfoDto1.getShopName(),
							visitScoreDetailInfoDto1.getShopScore(),visitScoreDetailInfoDto1.getSaleScore(),
							visitScoreDetailInfoDto1.getStaffScore(),visitScoreDetailInfoDto1.getTotalScore(),
							visitScoreDetailInfoDto1.getCreateBy(),visitScoreDetailInfoDto1.getEmpName(),
							visitScoreDetailInfoDto1.getCreateTime()});
		}
		String title = "巡店打分报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
	
}
