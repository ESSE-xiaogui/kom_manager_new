package com.transsion.store.job.service;

import java.text.SimpleDateFormat;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shangkang.core.exception.ServiceException;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.job.interfaces.SeqService;
import com.transsion.store.job.mapper.TSeqMapper;
import com.transsion.store.job.mapper.TShopSaleMainMapper;
import com.transsion.store.job.mapper.TShopStockMainMapper;

/*
 * refer GeneralService in kom pc 
 */

@Service("seqService")
public class SeqServiceImpl implements SeqService {

	private static final Logger logger = LoggerFactory.getLogger(SeqServiceImpl.class);
			
	@Autowired
	private TSeqMapper seqMapper;
	@Autowired
	private TShopSaleMainMapper shopSaleMainMapper;
	@Autowired
	private TShopStockMainMapper shopStockMainMapper;
	
	@Override
	public String getSysDocSeq(int companyId, String docCode) {
		Map<String, Object> seqMap = new HashMap<String, Object>();
		seqMap.put("COMPANY_ID", companyId);
		seqMap.put("DOC_CODE", docCode);
		Map result = seqMapper.getSysDocSeq(seqMap);
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyMMdd");
		String strDate = sf.format(date);
		long seqDBNo = Long.parseLong("" + result.get("SEQ_NO")) + 1;
		int docBitts = Integer.parseInt("" + result.get("DOC_BITTS"));
		int docLength = docCode == null ? 0 : docCode.length();
		int numLength = docBitts - 4 - docLength;
		String prefix = strDate.substring(0, 4);

		String seqNo = formatLenBit(seqDBNo, numLength);
		if (docCode.equals("MS")) {
			if (seqNo.length() < 7)
				seqNo = (new StringBuilder("0")).append(seqNo).toString();
			seqNo = getDeploymentLocation() + prefix + seqNo;
		} else {
			seqNo = docCode + prefix + seqNo;
		}

		Map<String, Object> updateSeqMap = new HashMap<String, Object>();
		updateSeqMap.put("COMPANY_ID", companyId);
		updateSeqMap.put("DOC_CODE", docCode);
		updateSeqMap.put("SEQ_DATE", date);
		updateSeqMap.put("SEQ_NO", seqDBNo);
		seqMapper.updateSysDocSeq(updateSeqMap);
		logger.debug("seqNo:" + seqNo);
		return seqNo;
	}
	/**
	 * @author guihua.zhang
	 * createDate 2016-09-01
	 * @see oracle数据库DT_SYS_DOCUMENTS表的seqNO字段保存(取库存表和销量表的billNo字段)
	 * */
	public String getSysDocSeqByNumber(int companyId, String docCode) throws ServiceException{
		if(UtilHelper.isEmpty(companyId) || UtilHelper.isEmpty(docCode)){
			throw new ServiceException();
		}
		String billNo = "";
		if(docCode.equals("MS")){			
			billNo = shopSaleMainMapper.getSysDocSeqBySales(companyId);
		}else if(docCode.equals("ST")){
			billNo = shopStockMainMapper.getSysDocSeqByStock(companyId);
		}
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyMMdd");
		String strDate = sf.format(date);
		String prefix = strDate.substring(0, 4);
		String seqNo = formatSeqNo(billNo);
		if(seqNo.length()==7){
			seqNo = "A"+prefix+seqNo;
//			System.out.println(seqNo);
		}else if(seqNo.length()==6){
			seqNo = "ST"+prefix+seqNo;
//			System.out.println(seqNo);
		}else{
			seqNo = docCode+prefix+seqNo;
		}
		Map<String, Object> updateSeqMap = new HashMap<String, Object>();
		updateSeqMap.put("COMPANY_ID", companyId);
		updateSeqMap.put("DOC_CODE", docCode);
		updateSeqMap.put("SEQ_DATE", date);
		updateSeqMap.put("SEQ_NO", seqNo);
		seqMapper.updateSysDocSeq(updateSeqMap);
		logger.debug("seqNo:" + seqNo);		
		return seqNo;
	}

	private String getDeploymentLocation() {
		return "A";
	}
	
	private String formatLenBit(long seqNo, int length) {
		String result;
		for (result = Long.toString(seqNo); result.length() < length; result = (new StringBuilder("0"))
				.append(result).toString());
		return result;
	}

	/**
	 * @author guihua.zhang
	 * createtime 2016/09/02
	 * @see 根据入参返回oracle的DT_SYS_DOCUMENTS表的seqNO字段规则
	 * @return 字符串seqNo
	 * */
	private String formatSeqNo(String billNo) throws ServiceException{
		if(UtilHelper.isEmpty(billNo)){
			throw new ServiceException();
		}
		String seqNo = "";
		Calendar cal = Calendar.getInstance();
		int sysDate =  cal.get(Calendar.MONTH)+1;
		if(billNo.contains("A")){
			int DateDB = Integer.parseInt(billNo.substring(3,5));
			if(sysDate>DateDB){
				seqNo = "0000001";
			}else{
			long seqDBNo = Long.parseLong("" + billNo.substring(billNo.length()-7)) + 1;
			seqNo = String.valueOf(seqDBNo);
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<7-seqNo.length();i++){
				sb.append("0");
			}
			sb.append(seqNo);
			seqNo = sb.toString();
			}
		}else{
			int DateDB = Integer.parseInt(billNo.substring(4,6));
			if(sysDate>DateDB){
				seqNo = "000001";
			}else{
			long seqDBNo = Long.parseLong("" + billNo.substring(billNo.length()-6)) + 1;
			seqNo = String.valueOf(seqDBNo);
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<6-seqNo.length();i++){
				sb.append("0");
			}
			sb.append(seqNo);
			seqNo = sb.toString();
			}
		}
		return seqNo;
	}

}
