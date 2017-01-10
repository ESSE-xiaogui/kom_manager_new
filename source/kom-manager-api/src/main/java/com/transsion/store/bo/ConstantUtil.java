package com.transsion.store.bo;

import java.util.ArrayList;
import java.util.List;

public class ConstantUtil {
	public static final List<String> BRAN_CODE_LIST= new ArrayList<String>();
	static {
		BRAN_CODE_LIST.add("TECNO");
	}
	/**
	 * IMEI保存成功
	 * */
	public static final int STATUS_ONE = 1;
	/**
	 * 前端传入IMEI与数据库重复
	 * */
	public static final int STATUS_TWO = 2;
	/**
	 * 非法IMEI
	 * */
	public static final int STATUS_THREE = 3;
	/**
	 * 品牌为空
	 * */
	public static final int STATUS_FOUR = 4;
	/**
	 * 品牌为TECNO时候，IMEI为空
	 * */
	public static final int STATUS_FIVE = 5;
	/**
	 * 前端传入重复IMEI
	 * */
	public static final int STATUS_SIX = 6;
	
	/**
	 * cache imei处理中
	 * */
	public static final int STATUS_SEVEN = 7;
}
