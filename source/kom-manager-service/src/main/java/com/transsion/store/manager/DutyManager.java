package com.transsion.store.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.dto.DutyResponseDto;
import com.transsion.store.resource.MessageStoreResource;
import com.transsion.store.service.DutyService;

@Service("dutyManager")
public class DutyManager {
	@Autowired
	private DutyService dutyService;
	
	/**
	 * 查询销售区域名称
	 * @return
	 * @throws ServiceException
	 */
	public DutyResponseDto findDutyName(java.lang.Long id) throws ServiceException{
		if(UtilHelper.isEmpty(id)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		String dutyName = dutyService.getDutyName(id);
		if(UtilHelper.isEmpty(dutyName)){
			throw new ServiceException(MessageStoreResource.ERROR_MESSAGE_PARAM_IS_NULL);
		}
		DutyResponseDto drd =new DutyResponseDto();
		drd.setDutyName(dutyName);
		return drd;
	}
	
}
