package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.ModelPrice;
import com.transsion.store.mapper.ModelPriceMapper;

@Service("modelPriceService")
public class ModelPriceService {
	
	@Autowired
	private ModelPriceMapper modelPriceMapper;
	
	
	
	
	public List<ModelPrice> findModelPrice() throws ServiceException{
		return modelPriceMapper.findModelPrice();
	}
}
