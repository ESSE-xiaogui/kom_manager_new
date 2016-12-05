package com.transsion.store.job.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.transsion.store.job.interfaces.SyncService;
import com.transsion.store.utils.PropertiesUtils;

public class SyncManager {

	private static final Logger logger = LoggerFactory.getLogger(SyncManager.class);

	public static final String DEFAULT_SPRING_CONFIG = "classpath*:kom-job-context.xml";

	private ApplicationContext context;

	public SyncManager(ApplicationContext context) {
		this.context = context;
	}

	public void start() {
		SyncService syncService = (SyncService) context.getBean("syncService");
		if (syncService != null) {
			String status = PropertiesUtils.rtReadProperties("task.init.status", "job");
			if (status.equals("0")) {
				String tableList = PropertiesUtils.rtReadProperties("task.init.list", "job");

				if (tableList != null && !"".equals(tableList)) {
					String[] tables = tableList.split(",");
					for (int i = 0; i < tables.length; i++) {
						try {
							String columns = PropertiesUtils.rtReadProperties(tables[i] + ".colums", "job");
							syncService.syncAllTableData(tables[i], columns);
						} catch (Exception e) {
							logger.error(e.getMessage());
						}
					}
					PropertiesUtils.setProperties("task.init.status", "1", "job");
				}
			} else {
				logger.info("task.init.status=1,not syncService data");
			}
		}
	}

	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(DEFAULT_SPRING_CONFIG);
			ClassPathXmlApplicationContext extContext = (ClassPathXmlApplicationContext) context;
			extContext.start();
			SyncManager syncManager = new SyncManager(context);
			syncManager.start();
			extContext.stop();
			extContext.close();
			extContext = null;
		} catch (Throwable e) {
			logger.error(e.getMessage(), e);
		}
	}

}
