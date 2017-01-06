package com.transsion.store.manager;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.transsion.store.resource.ExceptionDef;

@Service("errorMessageManager")
public class ErrorMessageManager {
	public List<String> findErrorMessageAll(){
		List<String> messageList = new ArrayList<String>();
		for(ExceptionDef message:ExceptionDef.values()){
			String messages = message.toString();
			messageList.add(messages);
		}
		return messageList;
	}
}
