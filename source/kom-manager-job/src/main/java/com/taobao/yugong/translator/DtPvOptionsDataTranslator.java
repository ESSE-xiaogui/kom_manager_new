package com.taobao.yugong.translator;

import com.shangkang.tools.UtilHelper;
import com.transsion.store.utils.PropertiesUtils;

public class DtPvOptionsDataTranslator extends BaseDataTranslator {

	@Override
	public String getTableName() {
		return "T_OPTION";
	}

	@Override
	public String[] getSrcColumnNames() {
		return PropertiesUtils.rtReadProperties("yugong.ext.DT_PV_OPTIONS.columns", "yugong_ext").split(",");
	}

	@Override
	public String[] getDestColumnNames() {
		return PropertiesUtils.rtReadProperties("yugong.ext.T_OPTION.columns", "yugong_ext").split(",");
	}

	@Override
	public String[] getSrcDeleteColumnNames() {
		String cloumns = PropertiesUtils.rtReadProperties("yugong.ext.DT_PV_OPTIONS.delete.columns", "yugong_ext");
		if (!UtilHelper.isEmpty(cloumns)) {
			return cloumns.split(",");
		} else {
			return null;
		}
	}
}
