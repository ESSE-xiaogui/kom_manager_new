package com.transsion.store.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.ModelPrice;
import com.transsion.store.facade.ModelPriceFacde;
import com.transsion.store.service.ModelPriceService;
@Component("modelPriceFacde")
public class ModelPriceFacdeImpl implements ModelPriceFacde {

	@Autowired
	private ModelPriceService modelPriceService;
	
	
	//查询 价格档位
	public List<ModelPrice> findModelPrice() throws ServiceException {
		return modelPriceService.findModelPrice();
	}

}
