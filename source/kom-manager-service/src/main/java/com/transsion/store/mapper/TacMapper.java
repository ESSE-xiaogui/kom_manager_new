package com.transsion.store.mapper;

import java.util.List;

import com.shangkang.core.mapper.GenericIBatisMapper;
import com.transsion.store.bo.Tac;

public interface TacMapper extends GenericIBatisMapper<Tac, java.lang.Long> {
	
	public List<Tac> findAllTac();

	public Tac findTac(String tac);

}
