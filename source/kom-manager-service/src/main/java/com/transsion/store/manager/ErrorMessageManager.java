package com.transsion.store.manager;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

import com.transsion.store.exception.ExceptionDef;

@Service("errorMessageManager")
public class ErrorMessageManager {
	
	public List<ExceptionDef> queryAllErrorMessage(){
		return Arrays.asList(ExceptionDef.values());
	}

}
