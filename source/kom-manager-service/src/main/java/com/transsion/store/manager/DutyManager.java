package com.transsion.store.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.dto.DutyResponseDto;
import com.transsion.store.service.DutyService;

@Service("dutyManager")
public class DutyManager {
	@Autowired
	private DutyService dutyService;
	
	/**
	 * 查询职位
	 * @return
	 * @throws ServiceException
	 */
	public List<DutyResponseDto> findDutyName() throws ServiceException{
		return dutyService.getDutyName();
	}
	
}
