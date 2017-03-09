package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.DataAccessFailureException;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.dto.GoalPromoterInfoDto;
import com.transsion.store.dto.GoalSupervisorInfoDto;
import com.transsion.store.mapper.GoalPromoterMapper;
import com.transsion.store.utils.ExcelUtils;

@Service("goalPromoterManager")
public class GoalPromoterManager {
	@Autowired
	private GoalPromoterMapper goalPromoterMapper;

	public byte[] getGoalPromoterByExcel(GoalPromoterInfoDto goalPromoterInfoDto) throws ServiceException {
		String[] headers = {"序号","事业部","国家","城市","年/月","用户名","员工姓名","职位","门店编码","门店名称","销售目标","实际销量"
						,"完成率","创建用户","创建用户姓名","创建时间"};
		List<GoalPromoterInfoDto> list = goalPromoterMapper.listGoalPromoterByProperty(goalPromoterInfoDto);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i=1;
		for(GoalPromoterInfoDto goalPromoterInfoDto1 :list){
			dataset.add(new Object[]{i++,goalPromoterInfoDto1.getCompanyCode(),
							goalPromoterInfoDto1.getCountryName(),goalPromoterInfoDto1.getCityName(),
							goalPromoterInfoDto1.getGoalMonth(),goalPromoterInfoDto1.getUserCode(),
							goalPromoterInfoDto1.getEmpName(),goalPromoterInfoDto1.getDutyName(),
							goalPromoterInfoDto1.getShopCode(),goalPromoterInfoDto1.getShopName(),
							goalPromoterInfoDto1.getSaleTarget(),goalPromoterInfoDto1.getSaleCurrent(),
							goalPromoterInfoDto1.getAchieved(),goalPromoterInfoDto1.getCreateBy(),
							goalPromoterInfoDto1.getCreatorName(),goalPromoterInfoDto1.getCreateTime()});
		}
		String title = "促销员销量目标设定报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
	
	

}
