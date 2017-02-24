/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 17:33:11
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

import javax.ws.rs.QueryParam;

import com.transsion.store.bo.ShopGrade;
import com.transsion.store.dto.ShopGradeDto;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import org.apache.ibatis.annotations.Param;

public interface ShopGradeMapper extends GenericIBatisMapper<ShopGrade, java.lang.Long> {

    public List<ShopGradeDto> listPaginationByProperty(Pagination<ShopGradeDto> pagination, @Param("shopGradeDto")ShopGradeDto shopGradeDto, @Param("orderBy") Map<String, String> orderBy, @Param("companyId")Integer companyId) throws DataAccessFailureException;
    public ShopGrade findShopGrade(@QueryParam("saleId") Long saleId);
}
