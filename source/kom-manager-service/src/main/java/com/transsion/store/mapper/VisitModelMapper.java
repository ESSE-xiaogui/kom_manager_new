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

import com.transsion.store.bo.VisitModel;
import com.transsion.store.dto.VisitModelDetailInfoDto;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import org.apache.ibatis.annotations.Param;

public interface VisitModelMapper extends GenericIBatisMapper<VisitModel, java.lang.Long> {

    public List<VisitModelDetailInfoDto> listPaginationByProperty(Pagination<VisitModelDetailInfoDto> pagination, @Param("visitModelDetailInfoDto")VisitModelDetailInfoDto visitModelDetailInfoDto, @Param("orderBy") Map<String, String> orderBy, @Param("companyId")Long companyId) throws DataAccessFailureException;

	public List<VisitModelDetailInfoDto> listVisitModelByProperty(@Param("visitModelDetailInfoDto")VisitModelDetailInfoDto visitModelDetailInfoDto);
}
