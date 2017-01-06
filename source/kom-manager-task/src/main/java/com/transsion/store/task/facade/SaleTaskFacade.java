package com.transsion.store.task.facade;

import com.shangkang.core.exception.ServiceException;

public interface SaleTaskFacade {
	public void saveSaleTask(Long taskId) throws ServiceException;
}
