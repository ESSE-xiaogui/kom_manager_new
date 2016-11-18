/**
* COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
*
* No part of this publication may be reproduced, stored in a retrieval system,
* or transmitted, on any form or by any means, electronic, mechanical, photocopying,
* recording, or otherwise, without the prior written permission of Liuzh.
*
* Created By: Liuzh
* Created On: 2016-11-18 15:56:35
*
* Amendment History:
*
* Amended By       Amended On      Amendment Description
* ------------     -----------     ---------------------------------------------
*
**/
package com.transsion.store.service;

import com.transsion.store.mapper.SystemDateMapper;
import com.shangkang.core.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("systemDateService")
public class SystemDateService {

	private SystemDateMapper	systemDateMapper;

	@Autowired
	public void setSystemDateMapper(SystemDateMapper systemDateMapper)
	{
		this.systemDateMapper = systemDateMapper;
	}
	
	public String getCurrentDate() throws ServiceException {
		return systemDateMapper.getCurrentDate();
	}
	
	public String getCurrentDateNumber() throws ServiceException
	{
		String currentDate = this.getCurrentDate();
		return currentDate.replaceAll(" ", "").replaceAll("-", "").replaceAll(":", "");
	}
}
