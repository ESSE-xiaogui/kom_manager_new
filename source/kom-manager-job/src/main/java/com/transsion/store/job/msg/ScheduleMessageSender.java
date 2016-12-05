package com.transsion.store.job.msg;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.job.interfaces.MessageSevice;
import com.transsion.store.utils.PropertiesUtils;

import org.apache.activemq.ScheduledMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import java.io.Serializable;
import java.util.Map;

/**
 */
@Service("scheduleMessageService")
public class ScheduleMessageSender implements MessageSevice {

	private static final Logger logger = LoggerFactory.getLogger(ScheduleMessageSender.class);

	public final static String MQ_SCHEDULED_DELAY="mq.scheduled.delay";
	
	@Autowired
	JmsTemplate scheduleJmsTemplate;

	/**
	 * 
	 * @param message
	 * @throws ServiceException
	 */
	public void sendMessage(Map<String, Object> msgMap) {
		scheduleJmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return createScheduleMessage(session, (Serializable) msgMap);
			}
		});
	}

	@Override
	public void sendMessage(String destinationName, Map<String, Object> msgMap) {
		scheduleJmsTemplate.send(destinationName, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return createScheduleMessage(session, (Serializable) msgMap);
			}
		});
	}
	
	private Message createScheduleMessage(Session session,Serializable msgMap) throws JMSException 
	{
		long delayTime = 5 * 60 * 1000;
		try {
			String delayValue = PropertiesUtils.rtReadProperties(MQ_SCHEDULED_DELAY, "mq");
			delayTime = Long.parseLong(delayValue.trim());
		} catch (Exception ex) {
			logger.error("parse schedule delay Value faild!", ex);
		}
		Message message = session.createObjectMessage(msgMap);
		message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delayTime);
		return message;
	}

}
