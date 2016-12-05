package com.transsion.store.job.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.taobao.yugong.YuGongLauncher;

public class SyncServiceThread {
	
	private static final Logger logger = LoggerFactory.getLogger(SyncServiceThread.class);
	
	private ApplicationContext context;
	private Thread initDataThread;
	private Thread yuGongThread;

	public SyncServiceThread(ApplicationContext context) {
		this.context=context;
		InitDataTask initDataTask = new InitDataTask();
		YuGongTask yuGongTask = new YuGongTask();
		initDataThread = new Thread(initDataTask, "InitDataTask");
		yuGongThread = new Thread(yuGongTask, "yuGongTask");
	}

	public void start() {
		initDataThread.start();
		yuGongThread.start();
	}

	public void stop() {
		initDataThread.interrupt();
		yuGongThread.interrupt();
	}

	
	/*
	 * InitDataTask
	 */
	class InitDataTask  implements Runnable{

		@Override
		public void run() {
			try {
				SyncManager syncManager = new SyncManager(context);
				syncManager.start();
			} catch (Throwable e) {
				logger.error(e.getMessage(), e);
			}
		}
		
	}
	
	
	/*
	 * YuGongTask
	 */
	class YuGongTask  implements Runnable{

		@Override
		public void run() {
			try {
				YuGongLauncher.main(null);
			} catch (Throwable e) {
				logger.error(e.getMessage(), e);
			}
		}
		
	}
	
}
