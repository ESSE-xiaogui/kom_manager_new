package com.transsion.store.facade;

import java.util.List;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.ModelPrice;

public interface ModelPriceFacde {
	public List<ModelPrice> findModelPrice() throws ServiceException;
}
