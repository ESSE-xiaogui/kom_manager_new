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

import com.transsion.store.bo.Shop;
import com.transsion.store.dto.ShopChildrenDto;
import com.transsion.store.dto.ShopUserDto;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import org.apache.ibatis.annotations.Param;

public interface ShopMapper extends GenericIBatisMapper<Shop, java.lang.Long> {

    public List<Shop> listPaginationByProperty(Pagination<Shop> pagination, @Param("shop")Shop shop, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;

    public List<ShopUserDto> findShopUser(@Param("userId")Integer userId) throws DataAccessFailureException;
    public List<ShopUserDto> findShop(@Param("companyId")Integer companyId) throws DataAccessFailureException;
    public Shop findShopId(@Param("shopCode")String shopCode)throws DataAccessFailureException;
    public List<ShopChildrenDto> findShopByRegionId (@Param("regionId")Long regionId,@Param("userName")String userName) throws DataAccessFailureException; 
    public List<Long> findShopIds (@Param("uid")Long uid) throws DataAccessFailureException; 

}
