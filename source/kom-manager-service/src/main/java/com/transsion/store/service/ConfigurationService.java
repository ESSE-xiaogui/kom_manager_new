package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.bo.Configuration;
import com.transsion.store.mapper.ConfigurationMapper;


@Service("configurationService")
public class ConfigurationService {
	
	@Autowired
	private ConfigurationMapper	configurationMapper;

	
	public void setAttributeMapper(ConfigurationMapper	configurationMapper)
	{
		this.configurationMapper = configurationMapper;
	}
	
	public Configuration getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return configurationMapper.getByPK(primaryKey);
	}

	public List<Configuration> list() throws ServiceException
	{
		return configurationMapper.list();
	}
	
	public String getValueByName(String name) throws ServiceException {
		Configuration configuration = new Configuration();
		List<Configuration> configurationList = configurationMapper.listByProperty(configuration);
		if (configurationList != null && configurationList.size() > 0) {
			return configurationList.get(0).getValue();
		}
		return null;
	}

}
