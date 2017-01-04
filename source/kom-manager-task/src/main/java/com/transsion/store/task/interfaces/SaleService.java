package com.transsion.store.task.interfaces;
import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Task;
import com.transsion.store.bo.TaskDetail;
import com.transsion.store.dto.SaleTaskDto;

public interface SaleService {
	public TaskDetail taskSales(SaleTaskDto saleTaskDto) throws ServiceException;
	/**
	 * 转换excel
	 * */
	public void getSaleTaskDto(Task task) throws ServiceException;
}
