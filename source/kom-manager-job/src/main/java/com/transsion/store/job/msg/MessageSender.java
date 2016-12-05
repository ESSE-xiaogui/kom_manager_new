package com.transsion.store.job.msg;

import com.shangkang.core.exception.ServiceException;
import com.transsion.store.job.interfaces.MessageSevice;

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
@Service("messageService")
public class MessageSender implements MessageSevice {
	@Autowired
	JmsTemplate jmsTemplate;

	/**
	 * 
	 * @param message
	 * @throws ServiceException
	 */
	public void sendMessage(Map<String, Object> msgMap) {
		jmsTemplate.send(new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {

				return session.createObjectMessage((Serializable) msgMap);
			}
		});
	}

	@Override
	public void sendMessage(String destinationName, Map<String, Object> msgMap) {
		jmsTemplate.send(destinationName, new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {

				return session.createObjectMessage((Serializable) msgMap);
			}
		});
	}
}
