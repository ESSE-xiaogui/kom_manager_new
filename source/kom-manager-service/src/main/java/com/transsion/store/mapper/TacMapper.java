package com.transsion.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shangkang.core.mapper.GenericIBatisMapper;
import com.transsion.store.bo.Tac;
import com.transsion.store.dto.TacDto;

public interface TacMapper extends GenericIBatisMapper<Tac, java.lang.Long> {
	
	public List<Tac> findAllTac();

	public Tac findTac(String tac);
	
	public TacDto findTacDto(@Param("tac")String tac);
	
	public List<TacDto> findAllTacDto();
	
	public int queryTotalCount();
	
	public void deleteAllTac();
	
	public void save(TacDto tacDto);
}
