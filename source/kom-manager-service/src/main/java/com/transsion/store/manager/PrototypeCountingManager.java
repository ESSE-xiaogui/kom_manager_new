package com.transsion.store.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.bo.Prototype;
import com.transsion.store.bo.PrototypeCounting;
import com.transsion.store.bo.PrototypeSettingTime;
import com.transsion.store.context.UserContext;
import com.transsion.store.dto.PrototypeCountingDto;
import com.transsion.store.dto.PrototypeSettingDto;
import com.transsion.store.exception.ExceptionDef;
import com.transsion.store.mapper.PrototypeCountingMapper;
import com.transsion.store.service.SystemDateService;
import com.transsion.store.utils.CacheUtils;
import com.transsion.store.utils.ExcelUtils;

@Service("/prototypeCountingManager")
public class PrototypeCountingManager {
	
	@Autowired
	private SystemDateService systemDateService;
	@Autowired
	private PrototypeCountingMapper prototypeCountingMapper;
	@Autowired
	private PrototypeSettingManager prototypeSettingManager;
	@Autowired
	private PrototypeManager prototypeManager;
	
	
	/**
	 * 新增样机盘点计划
	 * @param prototypeCounting
	 * @param token
	 */
	public void savePrototypeCounting(String token) throws ServiceException {
		// 是否登录
		if(UtilHelper.isEmpty(token)){
			throw new ServiceException(ExceptionDef.ERROR_USER_TOKEN_INVALID.getName());
		}
		// 登录信息是否为空
		UserContext userContext = (UserContext)CacheUtils.getSupporter().get(token);
		if(UtilHelper.isEmpty(userContext) || UtilHelper.isEmpty(userContext.getUser())){
			throw new ServiceException(ExceptionDef.ERROR_COMMON_PARAM_NULL.getName());
		}
		// 数据是否为空
		/*if(UtilHelper.isEmpty(prototypeCounting)){
			throw new ServiceException(ExceptionDef.ERROR_PROTOTYPECOUNTING_PARAM_NULL.getName());
		}*/
		
		List<PrototypeSettingDto> prototypeSettingDtos = prototypeSettingManager.getPrototypeSettingDtosByCurDate(new Date());
		List<Prototype> prototypes = prototypeManager.getPrototypesByPrototypeSettings(prototypeSettingDtos);
		
		// 循环样机，过滤判断进行
		if (prototypeSettingDtos != null && !prototypeSettingDtos.isEmpty()) {
			List<PrototypeSettingTime> prototypeSettingTimes = prototypeSettingDtos.get(0).getPrototypeSettingTimes();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
			
			for (PrototypeSettingTime prototypeSettingTime : prototypeSettingTimes) {
				for (Prototype prototype : prototypes) {
					try {
						int i = sdf.parse(prototype.getPublishTime()).compareTo(sdf.parse(prototypeSettingTime.getCountDate()));
						// 样机上样时间小于样机样机盘点日期设置的参数，则插入到prototypeCounting表
						if (i < 0) {
							PrototypeCounting prototypeCounting = new PrototypeCounting();
							
							prototypeCounting.setPrototypeId(prototype.getId());
							prototypeCounting.setCountingTime(prototypeSettingTime.getCountDate());
							prototypeCounting.setShopId(prototype.getShopId());
							prototypeCounting.setCompanyId(prototype.getCompanyId());
							prototypeCounting.setStatus(1);		// 未盘
							prototypeCounting.setCreateBy(userContext.getUserCode());
							prototypeCounting.setCreateTime(systemDateService.getCurrentDate());
							
							prototypeCountingMapper.save(prototypeCounting);
						}
						
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	public byte[] getPrototypeCountingByExcel(PrototypeCountingDto prototypeCountingDto)throws ServiceException  {
		String[] headers = {"序号","事业部","品牌","上传批次号","国家","城市","门店代码","门店名称","IMEI号","样机机型","计划盘点日期","上传时间",
		"盘点状态","上传用户", "员工姓名","备注说明"};
		List<PrototypeCountingDto> list = prototypeCountingMapper.listPrototypeCountingByProperty(prototypeCountingDto);
		List<Object[]> dataset = new ArrayList<Object[]>();
		int i=1;
		for(PrototypeCountingDto prototypeCountingDto1 :list){
			dataset.add(new Object[]{i++,prototypeCountingDto1.getCompanyCode(),prototypeCountingDto1.getBrandName(),
							prototypeCountingDto1.getPrototypeId(),prototypeCountingDto1.getCountryName(),
							prototypeCountingDto1.getCityName(),prototypeCountingDto1.getShopCode(),
							prototypeCountingDto1.getShopName(),prototypeCountingDto1.getImeiNo(),
							prototypeCountingDto1.getModelName(),prototypeCountingDto1.getCountingTime(),
							prototypeCountingDto1.getCreateTime(),prototypeCountingDto1.getStatus(),
							prototypeCountingDto1.getCreateBy(),prototypeCountingDto1.getEmpName(),
							prototypeCountingDto1.getRemark()});
		}
		String title = "样机盘点计划与追踪报表";
		return ExcelUtils.exportExcel(title, headers, dataset);
	}
}
