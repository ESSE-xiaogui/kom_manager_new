/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 17:33:09
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

import com.transsion.store.bo.Region;
import com.transsion.store.dto.RegionDto;
import com.transsion.store.dto.RegionListDto;
import com.transsion.store.dto.RegionShopDto;
import com.transsion.store.dto.ShopBindRegionDto;
import com.transsion.store.dto.ShopRegionChildrenDto;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import org.apache.ibatis.annotations.Param;

public interface RegionMapper extends GenericIBatisMapper<Region, java.lang.Long> {

    public List<RegionListDto> listPaginationByProperty(Pagination<RegionListDto> pagination, @Param("regionListDto")RegionListDto regionListDto, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;

	public List<RegionDto> findRegionsList(Integer companyId) throws DataAccessFailureException;

	public String getRegionName(Long id) throws DataAccessFailureException;
	
	public List<RegionShopDto> findRegionShop(@Param("companyId")Integer companyId) throws DataAccessFailureException;

	public RegionDto getByPKs(Long primaryKey) throws DataAccessFailureException;
	
	public List<ShopBindRegionDto> findRegion(@Param("userName")String userName) throws DataAccessFailureException;
	
	public List<ShopRegionChildrenDto> findRegionChildren(@Param("parentId")Long parentId,@Param("userName")String userName) throws DataAccessFailureException;
	
}
