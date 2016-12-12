package com.taobao.yugong.translator;

import com.shangkang.tools.UtilHelper;
import com.transsion.store.utils.PropertiesUtils;

public class DtPvUserOptionDataTranslator extends BaseDataTranslator {

	@Override
	public String getTableName() {
		return "T_USER_OPTION";
	}

	@Override
	public String[] getSrcColumnNames() {
		return PropertiesUtils.rtReadProperties("yugong.ext.DT_PV_USER_OPTION.columns", "yugong_ext").split(",");
	}

	@Override
	public String[] getDestColumnNames() {
		return PropertiesUtils.rtReadProperties("yugong.ext.T_USER_OPTION.columns", "yugong_ext").split(",");
	}
	
	@Override
	public String[] getSrcDeleteColumnNames() {
		String columns = PropertiesUtils.rtReadProperties("yugong.ext.DT_PV_USER_OPTION.delete.columns", "yugong_ext");
		if (!UtilHelper.isEmpty(columns)) {
			return columns.split(",");
		} else {
			return null;
		}
	}
}
