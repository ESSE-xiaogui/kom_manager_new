package com.transsion.store.message;

import java.io.Serializable;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.shangkang.core.exception.ServiceException;

@Service("messageService")
public class MessageServiceImpl implements MessageService{
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
