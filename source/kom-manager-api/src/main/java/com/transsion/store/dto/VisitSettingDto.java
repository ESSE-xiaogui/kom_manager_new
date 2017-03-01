package com.transsion.store.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.shangkang.tools.UtilHelper;


/**
 * VisitDefinitionDto info
 * @author guihua.zhang on 2017-03-01
 */
public class VisitSettingDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 打分项查询信息包括:门店形象,人员形象,业务技能
	 * */
	private List<VisitScoreSettingDto> visitScoreSettingDtoList;

	/**
	 * 打分项查询信息包括:门店形象,人员形象,业务技能
	 * */
	public List<VisitScoreSettingDto> getVisitScoreSettingDtoList() {
		return visitScoreSettingDtoList;
	}

	/**
	 * 打分项查询信息包括:门店形象,人员形象,业务技能
	 * */
	public void setVisitScoreSettingDtoList(List<VisitScoreSettingDto> visitScoreSettingDtoList) {
		this.visitScoreSettingDtoList = visitScoreSettingDtoList;
	}

	/**
	 * 根据类型获取相应需要的数据,例如:类型为门店形象
	 * */
	public List<VisitScoreSettingDto> getScoreSettingListByType(int type) {
		List<VisitScoreSettingDto> list = new ArrayList<VisitScoreSettingDto>();
		if(!UtilHelper.isEmpty(visitScoreSettingDtoList)){
			for(VisitScoreSettingDto vss:visitScoreSettingDtoList){
				VisitScoreSettingDto visit = new VisitScoreSettingDto();
				BeanUtils.copyProperties(vss, visit);
				list.add(visit);
		}
		}
		return list;
	}

	@Override
	public String toString() {
		return "VisitSettingDto [visitScoreSettingDtoList=" + visitScoreSettingDtoList + "]";
	}
	
}