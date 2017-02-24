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

import org.apache.ibatis.annotations.Param;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.transsion.store.bo.Shop;
import com.transsion.store.dto.ShopChildrenDto;
import com.transsion.store.dto.ShopInfoDto;
import com.transsion.store.dto.ShopLoginDto;
import com.transsion.store.dto.ShopUserDto;

public interface ShopMapper extends GenericIBatisMapper<Shop, java.lang.Long> {

    public List<ShopInfoDto> listPaginationByProperty(Pagination<ShopInfoDto> pagination, @Param("shopInfoDto")ShopInfoDto shopInfoDto, @Param("orderBy") Map<String, String> orderBy, @Param("companyId")Integer companyId) throws DataAccessFailureException;

    public List<ShopUserDto> findShopUser(@Param("userId")Integer userId) throws DataAccessFailureException;
    public List<ShopUserDto> findShop(@Param("companyId")Integer companyId) throws DataAccessFailureException;
    public Shop findShopId(@Param("shopCode")String shopCode)throws DataAccessFailureException;
    public List<ShopChildrenDto> findShopByRegionId (@Param("regionId")Long regionId,@Param("userName")String userName, @Param("companyId") Long companyId) throws DataAccessFailureException;
    public List<Long> findShopIds (@Param("uid")Long uid, @Param("companyId")Long companyId) throws DataAccessFailureException;
	public List<ShopLoginDto> findByPromoters(@Param("userId") Long userId,@Param("companyId") Long companyId)throws DataAccessFailureException;
	public List<Shop> findByPromoter(@Param("userId") Integer userId,@Param("companyId") Integer companyId)throws DataAccessFailureException;
	public List<Shop> findShopListByUser(@Param("userId") Integer userId,@Param("companyId") Integer companyId)throws DataAccessFailureException;
	
	public Shop queryShopByShopId(@Param("shopId")Long shopId, @Param("companyId")Long companyId) throws DataAccessFailureException;

	public ShopInfoDto getByPKey(Long primaryKey)throws DataAccessFailureException;

	public List<ShopInfoDto> listShopByProperty(@Param("shopInfoDto")ShopInfoDto shopInfoDto)throws DataAccessFailureException;
}
