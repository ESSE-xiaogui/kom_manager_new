package com.transsion.store.job.sync;

import org.springframework.stereotype.Service;

import com.transsion.store.job.interfaces.SyncService;

@Service("syncService")
public class SyncServiceImpl implements SyncService {

	@Override
	public void syncAllTableData(String tableName, String columns) {
		
	}

	@Override
	public void clearTableData(String tableName) {
		
	}

}
