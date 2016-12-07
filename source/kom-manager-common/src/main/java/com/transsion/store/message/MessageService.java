package com.transsion.store.message;

import java.util.Map;

public interface MessageService {
	public void sendMessage(Map<String, Object> msgMap);
	public void sendMessage(String destinationName, Map<String, Object> msgMap);
}
