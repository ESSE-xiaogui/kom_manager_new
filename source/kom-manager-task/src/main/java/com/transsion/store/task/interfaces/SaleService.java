package com.transsion.store.task.interfaces;

import java.util.List;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.dto.SaleTaskDto;

public interface SaleService {
	public List<SaleTaskDto> taskSales(List<SaleTaskDto> saleTaskDtoList) throws ServiceException;
}
