package com.transsion.store.job.sync;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shangkang.core.util.SpringBeanHelper;
import com.shangkang.tools.UtilHelper;
import com.transsion.store.common.HTTPUtil;
import com.transsion.store.dto.TacDto;
import com.transsion.store.job.service.ImeiTacServiceImpl;
import com.transsion.store.utils.PropertiesUtils;

public class ImeiTacSyncJob extends QuartzJobBean{
	
	private static final Logger logger = LoggerFactory.getLogger(ImeiTacSyncJob.class);

	public static final String[] brandList = {"Infinix", "Itel", "Tecno"};

	@Override
	protected void executeInternal(JobExecutionContext arg0) {
		logger.info("call syncImeiTacJob...");
		syncImeiTacJob();
	}
	
	@SuppressWarnings("rawtypes")
	public void syncImeiTacJob() {
		ImeiTacServiceImpl imeiTacService = (ImeiTacServiceImpl) SpringBeanHelper.getBean("imeiTacService");
		if (imeiTacService != null) {
			try {
				String TACAPI = PropertiesUtils.rtReadProperties("TACAPI", "quartz");
				JSONObject jsonObject = JSONObject.parseObject(HTTPUtil.sendGetRequest(TACAPI));
				
		    	JSONObject jsonObj = jsonObject.getJSONObject("brandModelMap");
		    	
		    	String key = "model";
				JSONObject obj = null;
				
				int count = 0;
				
				List<TacDto> list = new ArrayList<TacDto>();
		    	for (int i = 0; i < brandList.length; i++) {
		    		JSONArray jsonArray = JSONArray.parseArray(jsonObj.get(brandList[i]).toString());
		    		for (int j = 0; j < jsonArray.size(); j++) {
		    			JSONObject object = JSONObject.parseObject(jsonArray.get(j).toString());
		    			Iterator iterator = object.keySet().iterator();
		    			while(iterator.hasNext()){
		    				key = (String) iterator.next();
		    			    obj = object.getJSONObject(key);
					        String model = obj.getString("model");
					        String tac = obj.getString("tac").replace("[", "").replace("]", "").replace("\"", "");
					        String[] tacList = tac.split(",");
					        for (int k = 0; k < tacList.length; k++) {
					        	TacDto tacDto = new TacDto();
					        	if (!UtilHelper.isEmpty(tacList[k])) {
					        		count++;
					        		tacDto.setTac(tacList[k]);
					        		tacDto.setImei(tacList[k]);
					        		tacDto.setBrandCode(brandList[i].toUpperCase());
					        		tacDto.setModelMatCode(model);
					        		list.add(tacDto);
					        	}
				        	}
		    			}
		    		}
		    	}
		    	
				int totalCount = imeiTacService.queryTotalCount();
				logger.info("Oracle T_IMEI_TAC count:" + count + " MySql T_IMEI_TAC count:" + totalCount);
				
				if (count > totalCount) {
					imeiTacService.deleteAllTac();
					logger.info("delete T_IMEI_TAC data success");
					for (TacDto tacDto_ : list) {
						imeiTacService.save(tacDto_);
					}
					logger.info("insert data to T_IMEI_TAC success");
				}
			} catch (Exception e) {
				logger.error("execute syncImeiTacJob error:" + e.getMessage());
			}
		}
	} 
	
	public static void main(String[] args) {
		ImeiTacSyncJob imeiTacSyncJob = new ImeiTacSyncJob();
		imeiTacSyncJob.syncImeiTacJob();
	}
}
