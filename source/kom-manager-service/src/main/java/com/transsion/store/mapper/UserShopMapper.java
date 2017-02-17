package com.transsion.store.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.shangkang.core.exception.DataAccessFailureException;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.transsion.store.bo.UserShop;

public interface UserShopMapper extends GenericIBatisMapper<UserShop, java.lang.Long>{
	public void deleteByUserId(@Param("userId")Long userId) throws DataAccessFailureException;
	public void saveUserShop(UserShop userShop) throws DataAccessFailureException;
	
	public List<Integer> queryShopIdByUserId(Integer userId) throws DataAccessFailureException;
}
