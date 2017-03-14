package com.transsion.store.job.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transsion.store.dto.TacDto;
import com.transsion.store.mapper.TacMapper;
import com.transsion.store.service.TacService;

@Service("imeiTacService")
public class ImeiTacServiceImpl {
	
	@Autowired
	private TacMapper tImeiTacMapper;
	
	@Autowired
	private TacService tiImeiTacService;
	
	public int queryTotalCount() {
		return tImeiTacMapper.queryTotalCount();
	}
	
	public void deleteAllTac() {
		tImeiTacMapper.deleteAllTac();
	}
	
	public void save(TacDto tacDto) {
		tiImeiTacService.save(tacDto);
	}
}
