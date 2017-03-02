/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-2-21 10:24:48
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

import com.transsion.store.bo.VisitFeedback;
import com.transsion.store.dto.VisitFeedBackInfoDto;
import com.transsion.store.dto.VisitFeedbackDto;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import org.apache.ibatis.annotations.Param;

public interface VisitFeedbackMapper extends GenericIBatisMapper<VisitFeedback, java.lang.Long> {

    public List<VisitFeedBackInfoDto> listPaginationByProperty(Pagination<VisitFeedBackInfoDto> pagination, @Param("visitFeedBackInfoDto")VisitFeedBackInfoDto visitFeedBackInfoDto, @Param("orderBy") Map<String, String> orderBy, @Param("companyId")Integer companyId) throws DataAccessFailureException;

	public List<VisitFeedBackInfoDto> listVisitFeedBackByProperty(@Param("visitFeedBackInfoDto")VisitFeedBackInfoDto visitFeedBackInfoDto)throws DataAccessFailureException;
	
	public VisitFeedbackDto queryVisitFeedbackByVisitId(Long visitId) throws DataAccessFailureException;
}
