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
	
	/**
	 * 根据类型查询信息
	 * */
	public List<ModelPrice> findModelPrice(String tableType) throws ServiceException{
		return modelPriceMapper.findModelPrice(tableType);
	}
}
