package com.transsion.store.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.dto.TacDto;
import com.transsion.store.mapper.TacMapper;

@Service("tacManager")
public class TacManager {
	Logger logger = LoggerFactory.getLogger(TacManager.class);

	@Autowired
	private TacMapper tacMapper;
	
	public TacDto queryTacInfoByImei(String imei) throws ServiceException {
		logger.debug(Thread.currentThread().getName() + "**********************通过imei号查询品牌机型start：" + imei);
		if (imei == null || imei.length() < 8) {
			return null;
		}
		String tac = imei.substring(0, 8);
		TacDto tacDto = tacMapper.findTac(tac);
		if(!UtilHelper.isEmpty(tacDto)){
			tacDto.setImei(imei);
		}
		logger.debug(Thread.currentThread().getName() + "**********************通过imei号查询品牌机型end：" + tacDto);
		return tacDto;
	}
}
