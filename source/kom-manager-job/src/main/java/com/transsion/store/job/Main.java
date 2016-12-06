package com.transsion.store.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.transsion.store.job.sync.SyncServiceThread;

public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static final String DEFAULT_SPRING_CONFIG = "classpath*:kom-job-context.xml";

	static ClassPathXmlApplicationContext context;

	public static ClassPathXmlApplicationContext getContext() {
		return context;
	}

	public void start() {
		context = new ClassPathXmlApplicationContext(DEFAULT_SPRING_CONFIG);
		context.start();
		SyncServiceThread syncService = new SyncServiceThread(context);
		syncService.start();
	}

	public void stop() {
		try {
			if (context != null) {
				context.stop();
				context.close();
				context = null;
			}
		} catch (Throwable e) {
			logger.error(e.getMessage(), e);
		}
	}

	public static void main(String[] args) {
		Main mainApp = new Main();
		mainApp.start();
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				try {
					logger.info("## stop kom.job");
					mainApp.stop();
				} catch (Throwable e) {
					logger.error(e.getMessage(), e);
				} finally {
					logger.info("## kom.job is down.");
				}
			}
		});

		logger.info("kom.job started!");
/*		SeqService seqService = (SeqService)context.getBean("seqService");
		int companyId = 1000;
		String docCode = "MS";
		try {
			String seqNo = seqService.getSysDocSeqByStockAndSales(companyId, docCode);
			System.out.println(seqNo);
		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
	}
	
}
