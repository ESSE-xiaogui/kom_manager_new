package com.transsion.store.mapper;


import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.transsion.store.bo.Configuration;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface ConfigurationMapper extends GenericIBatisMapper<Configuration, java.lang.Long> {

    public List<Configuration> listPaginationByProperty(Pagination<Configuration> pagination, @Param("configuration") Configuration configuration, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;

}
