package com.taobao.yugong.translator;

import com.shangkang.tools.UtilHelper;
import com.transsion.store.utils.PropertiesUtils;

public class TBbBomElementsDataTranslator extends BaseDataTranslator {

	@Override
	public String getTableName() {
		return "T_MODEL";
	}

	@Override
	public String[] getSrcColumnNames() {
		return PropertiesUtils.rtReadProperties("yugong.ext.T_BB_BOM_ELEMENTS.columns", "yugong_ext").split(",");
	}

	@Override
	public String[] getDestColumnNames() {
		return PropertiesUtils.rtReadProperties("yugong.ext.T_MODEL.columns", "yugong_ext").split(",");
	}

	@Override
	public String[] getSrcDeleteColumnNames() {
		String cloumns = PropertiesUtils.rtReadProperties("yugong.ext.T_BB_BOM_ELEMENTS.delete.columns", "yugong_ext");
		if (!UtilHelper.isEmpty(cloumns)) {
			return cloumns.split(",");
		} else {
			return null;
		}
	}
}
