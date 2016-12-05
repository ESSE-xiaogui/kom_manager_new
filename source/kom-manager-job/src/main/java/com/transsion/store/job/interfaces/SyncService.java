package com.transsion.store.job.interfaces;

import org.springframework.stereotype.Service;

public interface SyncService {

	public void syncAllTableData(String tableName, String columns);

	public void clearTableData(String tableName);
}
