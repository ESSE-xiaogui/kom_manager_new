package com.transsion.store.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static final String DEFAULT_SPRING_CONFIG = "classpath*:kom-task-context.xml";
	static ClassPathXmlApplicationContext context;
	public static ClassPathXmlApplicationContext getContext() {
		return context;
	}

	public void start() {
		context = new ClassPathXmlApplicationContext(DEFAULT_SPRING_CONFIG);
		context.start();
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
					logger.info("## stop kom.manager.task");
					mainApp.stop();
				} catch (Throwable e) {
					logger.error(e.getMessage(), e);
				} finally {
					logger.info("## kom.manager.task is stopped!.");
				}
			}
		});

		logger.info("kom.manager.task started!");
	}
	
}
