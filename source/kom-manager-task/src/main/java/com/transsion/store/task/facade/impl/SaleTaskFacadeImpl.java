package com.transsion.store.task.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.task.facade.SaleTaskFacade;
import com.transsion.store.task.manager.SaleTaskManager;

@Component("saleTaskFacade")
public class SaleTaskFacadeImpl implements SaleTaskFacade{

	@Autowired
	private SaleTaskManager saleTaskManager;
	public void saveSaleTask(Long taskId) throws ServiceException {
		saleTaskManager.getSaleTaskDto(taskId);
	}

}
