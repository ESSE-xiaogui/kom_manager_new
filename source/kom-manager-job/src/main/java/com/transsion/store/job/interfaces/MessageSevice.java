package com.transsion.store.job.interfaces;

import java.util.Map;

/**
 */
public interface MessageSevice {

	public void sendMessage(Map<String, Object> msgMap);
	
	public void sendMessage(String destinationName, Map<String, Object> msgMap);
	
}
