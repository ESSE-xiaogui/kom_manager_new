package com.transsion.store.task.msg;

import java.util.Map;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.transsion.store.bo.Task;
import com.transsion.store.task.interfaces.SaleService;


public class MessageHandler implements MessageListener{
	private static final Logger logger = LoggerFactory.getLogger(MessageHandler.class);
	public static final String SAVE_TASK = "task.saveTask";

	@Autowired
	private SaleService saleService;
	public void onMessage(Message message) {
		try{
			String msgId = message.getJMSMessageID();
			logger.debug("receive msg: msg id = " + msgId);
			if (message instanceof ObjectMessage) {
				ObjectMessage objMsg = (ObjectMessage) message;
				Object obj = objMsg.getObject();
				logger.debug("receive obj msg: obj=" + obj.toString());
				if (obj instanceof Map) {
					Map map = (Map) obj;
					String type = (String) map.get("type");
					try{
						if(SAVE_TASK.equals(type)){
							Task task = (Task)map.get("payload");
							logger.info("receive msg: msg type = " + SAVE_TASK);
							saleService.getSaleTaskDto(task.getTaskType());
						}
					}catch (Throwable e) {
						logger.error("onMessage error:", e);
					}
				}
			}else if (message instanceof TextMessage) {
				TextMessage textMsg = (TextMessage) message;
				logger.debug("receive text msg: msg text=" + textMsg.getText());
			} else {
				logger.debug("ignore msg");
			}
		}catch (Throwable e) {
			logger.error("onMessage error:", e);
		}		
			
	}

}
