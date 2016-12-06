package com.transsion.store.job.msg;

import java.util.HashMap;
import java.util.Map;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shangkang.core.exception.ServiceException;

public class MessageHandler implements MessageListener {

	private static final Logger logger = LoggerFactory.getLogger(MessageHandler.class);

	public static final String MSG_SALE_INSERT = "SALE.CREATE";

	public static final String MSG_STOCK_INSERT = "STOCK.CREATE";

	public void onMessage(Message message) {
		try {
			String msgId = message.getJMSMessageID();
			logger.debug("receive msg: msg id = " + msgId);
			if (message instanceof ObjectMessage) {
				ObjectMessage objMsg = (ObjectMessage) message;
				Object obj = objMsg.getObject();
				logger.debug("receive obj msg: obj=" + obj.toString());
				if (obj instanceof Map) {
					Map map = (Map) obj;
					String method = (String) map.get("method");
					try {
						if (MSG_SALE_INSERT.equals(method)) {
							logger.info("receive msg: msg type = " + MSG_SALE_INSERT);
						} else if (MSG_STOCK_INSERT.equals(method)) {
							logger.info("receive msg: msg type = " + MSG_STOCK_INSERT);
						}
						// remove
						throw new ServiceException();
					} catch (ServiceException serviceException) {
						// resend message to schedule queue
						Map<String, Object> messages = new HashMap<String, Object>();
						messages.put("method", method);
						if (MSG_SALE_INSERT.equals(method)) {
						} else if (MSG_STOCK_INSERT.equals(method)) {
						}
					}
				}
			} else if (message instanceof TextMessage) {
				TextMessage textMsg = (TextMessage) message;
				logger.debug("receive text msg: msg text=" + textMsg.getText());
			} else {
				logger.debug("ignore msg");
			}
		} catch (Throwable e) {
			logger.error("onMessage error:", e);
		}
	}

}