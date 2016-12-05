package com.transsion.store.job.msg;


import javax.jms.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ScheduleMessageHandler extends MessageHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(ScheduleMessageHandler.class);

	public void onMessage(Message message) {
		logger.info("sechedule queue message handler called!");
		super.onMessage(message);
	}

}