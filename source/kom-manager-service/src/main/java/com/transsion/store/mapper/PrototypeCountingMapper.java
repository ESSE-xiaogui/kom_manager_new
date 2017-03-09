/**
 * COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-3-1 16:31:41
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.transsion.store.bo.PrototypeCounting;
import com.transsion.store.dto.PrototypeCountingDto;
import com.transsion.store.dto.PrototypeDto;

public interface PrototypeCountingMapper extends GenericIBatisMapper<PrototypeCounting, java.lang.Long> {

    public List<PrototypeCountingDto> listPaginationByProperty(Pagination<PrototypeCountingDto> pagination, @Param("prototypeCountingDto")PrototypeCountingDto prototypeCountingDto, @Param("orderBy") Map<String, String> orderBy,@Param("companyId")Long companyId) throws DataAccessFailureException;

	public List<PrototypeCountingDto> listPrototypeCountingByProperty(@Param("prototypeCountingDto")PrototypeCountingDto prototypeCountingDto);

	public PrototypeCountingDto getByPKey(@Param("primaryKey")Long primaryKey);
	
	// 每月底把未盘点的机型置为过期
	public void specialUpdate(@Param("date")String date);
	
	// 根据
	public List<PrototypeCounting> listPrototypeCountingByPrototypeDto(@Param("prototypeDto")PrototypeDto prototypeDto);
}
