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

import com.transsion.store.bo.VisitSale;
import com.transsion.store.dto.VisitSaleInfoDto;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import org.apache.ibatis.annotations.Param;

public interface VisitSaleMapper extends GenericIBatisMapper<VisitSale, java.lang.Long> {

    public List<VisitSaleInfoDto> listPaginationByProperty(Pagination<VisitSaleInfoDto> pagination, @Param("visitSaleInfoDto")VisitSaleInfoDto visitSaleInfoDto, @Param("orderBy") Map<String, String> orderBy, @Param("companyId")Long companyId) throws DataAccessFailureException;

	public List<VisitSaleInfoDto> listVisitSaleByProperty(@Param("visitSaleInfoDto")VisitSaleInfoDto visitSaleInfoDto)throws DataAccessFailureException;
}
