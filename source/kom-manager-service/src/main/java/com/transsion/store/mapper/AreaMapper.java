/**
 * COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-3-9 15:06:14
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
import com.transsion.store.bo.Area;
import com.transsion.store.dto.AreaDto;
import com.transsion.store.dto.AreaShopDto;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import org.apache.ibatis.annotations.Param;

public interface AreaMapper extends GenericIBatisMapper<Area, java.lang.Long> {

    public List<AreaDto> listPaginationByProperty(Pagination<AreaDto> pagination, @Param("areaDto")AreaDto areaDto, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;

	public Long getLatestId()throws DataAccessFailureException;

	public List<AreaDto> findAreaList(@Param("companyId")Long companyId,@Param("parentId")Long parentId)throws DataAccessFailureException;

	public AreaDto getByPKey(Long primaryKey)throws DataAccessFailureException;

	public List<AreaShopDto> findArea(@Param("companyId")Long companyId,@Param("parentId")Long parentId);
}
