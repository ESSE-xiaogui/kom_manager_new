package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shangkang.core.exception.ServiceException;

import com.transsion.store.dto.VisitFeedBackInfoDto;
import com.transsion.store.mapper.VisitFeedbackMapper;
import com.transsion.store.utils.ExcelUtils;

@Service("visitFeedBackManager")
public class VisitFeedBackManager {
	@Autowired
	private VisitFeedbackMapper visitFeedbackMapper;

	/**
	 * 问题反馈导出Excel
	 * @param visitFeedBackInfoDto
	 * @return
	 * @throws ServiceException 
	 */
	public byte[] getVisitFeedBackByExcel(VisitFeedBackInfoDto visitFeedBackInfoDto) throws ServiceException {
		String[] headers = {"序号","巡店单号","事业部","国家","城市","门店编码","门店名称","上传用户", "员工姓名",
		"上传时间"};
		List<VisitFeedBackInfoDto> list = visitFeedbackMapper.listVisitFeedBackByProperty(visitFeedBackInfoDto);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i=1;
		for(VisitFeedBackInfoDto visitFeedBackInfoDto1 :list){
			dataset.add(new Object[]{i++,visitFeedBackInfoDto1.getVisitNo(),visitFeedBackInfoDto1.getCompanyCode(),
							visitFeedBackInfoDto1.getCountryName(),visitFeedBackInfoDto1.getCityName(),
							visitFeedBackInfoDto1.getShopCode(),visitFeedBackInfoDto1.getShopName(),
							visitFeedBackInfoDto1.getCreateBy(),visitFeedBackInfoDto1.getEmpName(),
							visitFeedBackInfoDto1.getCreateTime()});
		}
		String title = "问题反馈报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
}
