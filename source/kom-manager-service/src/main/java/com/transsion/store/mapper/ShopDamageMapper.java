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

import com.transsion.store.bo.ShopDamage;
import com.transsion.store.dto.ShopDamageDto;
import com.transsion.store.dto.ShopDamageInfoDto;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import org.apache.ibatis.annotations.Param;

public interface ShopDamageMapper extends GenericIBatisMapper<ShopDamage, java.lang.Long> {

    public List<ShopDamageDto> listPaginationByProperty(Pagination<ShopDamageDto> pagination, @Param("shopDamageDto")ShopDamageDto shopDamageDto, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
    
    public ShopDamageDto queryDetailById(Long damageId) throws DataAccessFailureException;
    
    public List<ShopDamageDto> queryListByProperty(@Param("shopDamageDto")ShopDamageDto shopDamageDto);
    
    public List<ShopDamageInfoDto> queryShopDamageList(Long shopId) throws DataAccessFailureException;
}
