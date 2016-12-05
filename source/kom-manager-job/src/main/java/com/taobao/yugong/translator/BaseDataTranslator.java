package com.taobao.yugong.translator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taobao.yugong.common.db.meta.ColumnValue;
import com.taobao.yugong.common.model.record.Record;
import com.taobao.yugong.translator.AbstractDataTranslator;
import com.taobao.yugong.translator.DataTranslator;

public class BaseDataTranslator extends AbstractDataTranslator implements DataTranslator {

	private static final Logger logger = LoggerFactory.getLogger(BaseDataTranslator.class);
			

	public BaseDataTranslator()
	{
		//class init by yugong, and can't access with spring autowire
		logger.debug("init");
	}
	
	public boolean translator(Record record) {
		logger.debug("translator " + record);
		ColumnValue value = record.getColumnByName("BILLNO");
		Object obj = value.getValue();
		if (obj != null) {
			String billNo = obj.toString();
			try {
					//tbd
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
				return false;
			}
		}
		return true;
	}

}
