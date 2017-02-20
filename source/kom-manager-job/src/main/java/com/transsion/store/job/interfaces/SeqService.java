
package com.transsion.store.job.interfaces;

import com.shangkang.core.exception.ServiceException;

public interface SeqService {
	public String getSysDocSeq(int companyId, String docCode);
	/**
	 * @author guihua.zhang
	 * createDate 2016-09-01
	 * oracle数据库DT_SYS_DOCUMENTS表的seqNO字段保存(取库存表和销量表的billNo字段)
	 * */
	public String getSysDocSeqByNumber(int companyId, String docCode) throws ServiceException;
}
