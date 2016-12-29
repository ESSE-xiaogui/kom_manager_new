package com.transsion.store.task.interfaces;

import java.util.List;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Task;
import com.transsion.store.dto.SaleTaskDto;

public interface SaleService {
	public void taskSales(List<SaleTaskDto> saleTaskDtoList,Long taskId) throws ServiceException;
	/**
	 * 转换excel
	 * */
	public void getSaleTaskDto(Task task) throws ServiceException;
}
