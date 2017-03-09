package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transsion.store.dto.GoalModelInfoDto;
import com.transsion.store.mapper.GoalModelMapper;
import com.transsion.store.utils.ExcelUtils;

@Service("goalModelManager")
public class GoalModelManager {
	
	@Autowired
	private GoalModelMapper goalModelMapper;

	public byte[] getGoalModelByExcel(GoalModelInfoDto goalModelInfoDto) {
		String[] headers = {"序号","事业部","国家","城市","年/月","门店编码","门店名称","重点机型","销售目标","实际销量"
						,"完成率","创建用户","创建用户姓名","创建时间"};
		List<GoalModelInfoDto> list = goalModelMapper.listGoalModelByProperty(goalModelInfoDto);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i=1;
		for(GoalModelInfoDto goalModelInfoDto1 :list){
			dataset.add(new Object[]{i++,goalModelInfoDto1.getCompanyCode(),
							goalModelInfoDto1.getCountryName(),goalModelInfoDto1.getCityName(),
							goalModelInfoDto1.getGoalMonth(),goalModelInfoDto1.getShopCode(),
							goalModelInfoDto1.getShopName(),goalModelInfoDto1.getModelCode(),
							goalModelInfoDto1.getSaleTarget(),goalModelInfoDto1.getSaleCurrent(),
							goalModelInfoDto1.getAchieved(),goalModelInfoDto1.getCreateBy(),
							goalModelInfoDto1.getCreatorName(),goalModelInfoDto1.getCreateTime()});
		}
		String title = "重点机型销量目标设定报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
	
	

}
