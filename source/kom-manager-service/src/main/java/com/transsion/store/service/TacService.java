package com.transsion.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transsion.store.bo.Tac;
import com.transsion.store.dto.TacDto;
import com.transsion.store.mapper.TacMapper;


@Service("tacService")
public class TacService {
	
	@Autowired
	private TacMapper tacMapper;
	
	public List<Tac> queryAllTacInfo(){
		return tacMapper.findAllTac();
	}
	
	public TacDto findTacDto(String tac){
		return tacMapper.findTacDto(tac);
	}
	
	public List<TacDto> findAllTacDto(){
		return tacMapper.findAllTacDto();
	}
	
	public int queryTotalCount() {
		return tacMapper.queryTotalCount();
	}
	
	public void deleteAllTac() {
		tacMapper.deleteAllTac();
	}
	
	public void save(TacDto tacDto) {
		tacMapper.save(tacDto);
	}
}
