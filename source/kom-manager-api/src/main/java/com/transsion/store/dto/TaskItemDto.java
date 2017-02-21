package com.transsion.store.dto;

import java.io.Serializable;

public class TaskItemDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 成功条数
	 * */
	private Integer successNum;
	
	/**
	 * 失败条数
	 * */
	private Integer failNum;

	/**
	 * 成功条数
	 * */
	public Integer getSuccessNum() {
		return successNum;
	}

	/**
	 * 成功条数
	 * */
	public void setSuccessNum(Integer successNum) {
		this.successNum = successNum;
	}

	/**
	 * 失败条数
	 * */
	public Integer getFailNum() {
		return failNum;
	}

	/**
	 * 失败条数
	 * */
	public void setFailNum(Integer failNum) {
		this.failNum = failNum;
	}

	@Override
	public String toString() {
		return "TaskItemDto [successNum=" + successNum + ", failNum=" + failNum + "]";
	}
}
