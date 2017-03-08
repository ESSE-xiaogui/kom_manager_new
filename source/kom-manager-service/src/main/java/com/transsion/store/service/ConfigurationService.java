package com.transsion.store.service;

import java.util.List;

import com.shangkang.core.bo.Pagination;
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
	
	/**
	 * 通过主键查询实体对象
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public Configuration getByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return configurationMapper.getByPK(primaryKey);
	}

	/**
	 * 查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Configuration> list() throws ServiceException
	{
		return configurationMapper.list();
	}

	/**
	 * 根据查询条件查询所有记录
	 * @return
	 * @throws ServiceException
	 */
	public List<Configuration> listByProperty(Configuration configuration)
			throws ServiceException
	{
		return configurationMapper.listByProperty(configuration);
	}

	/**
	 * 根据查询条件查询分页记录
	 * @return
	 * @throws ServiceException
	 */
	public Pagination<Configuration> listPaginationByProperty(Pagination<Configuration> pagination, Configuration configuration)
			throws ServiceException
	{
		List<Configuration> list = configurationMapper.listPaginationByProperty(pagination, configuration, pagination.getOrderBy());

		pagination.setResultList(list);

		return pagination;
	}

	/**
	 * 根据主键删除记录
	 * @param primaryKey
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByPK(java.lang.Long primaryKey) throws ServiceException
	{
		return configurationMapper.deleteByPK(primaryKey);
	}

	/**
	 * 根据多个主键删除记录
	 * @param primaryKeys
	 * @throws ServiceException
	 */
	public void deleteByPKeys(List<java.lang.Long> primaryKeys) throws ServiceException
	{
		configurationMapper.deleteByPKeys(primaryKeys);
	}

	/**
	 * 根据传入参数删除记录
	 * @param configuration
	 * @return
	 * @throws ServiceException
	 */
	public int deleteByProperty(Configuration configuration) throws ServiceException
	{
		return configurationMapper.deleteByProperty(configuration);
	}

	/**
	 * 保存记录
	 * @param configuration
	 * @return
	 * @throws ServiceException
	 */
	public void save(Configuration configuration) throws ServiceException
	{
		configurationMapper.save(configuration);
	}

	/**
	 * 更新记录
	 * @param configuration
	 * @return
	 * @throws ServiceException
	 */
	public int update(Configuration configuration) throws ServiceException
	{
		return configurationMapper.update(configuration);
	}

	/**
	 * 保存或更新记录
	 * @param configuration
	 * @return
	 * @throws ServiceException
	 */
	public int saveOrUpdate(Configuration configuration) throws ServiceException {
		return configurationMapper.saveOrUpdate(configuration);
	}

	/**
	 * 批量保存或更新记录
	 * @param list
	 * @return
	 * @throws ServiceException
	 */
	public int batchSaveOrUpdate(List<Configuration> list) throws ServiceException {
		return configurationMapper.batchSaveOrUpdate(list);
	}

	/**
	 * 根据条件查询记录条数
	 * @param configuration
	 * @return
	 * @throws ServiceException
	 */
	public int findByCount(Configuration configuration) throws ServiceException
	{
		return configurationMapper.findByCount(configuration);
	}
	
	public String getValueByName(String name) throws ServiceException {
		Configuration configuration = new Configuration();
		configuration.setName(name);
		List<Configuration> configurationList = configurationMapper.listByProperty(configuration);
		if (configurationList != null && configurationList.size() > 0) {
			return configurationList.get(0).getValue();
		}
		return null;
	}

}
