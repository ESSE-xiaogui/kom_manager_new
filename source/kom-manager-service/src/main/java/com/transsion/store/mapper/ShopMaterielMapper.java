/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-2-17 11:25:38
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
import com.transsion.store.bo.ShopMateriel;

public interface ShopMaterielMapper extends GenericIBatisMapper<ShopMateriel, java.lang.Long> {

    public List<ShopMateriel> listPaginationByProperty(Pagination<ShopMateriel> pagination, @Param("shopMateriel")ShopMateriel shopMateriel, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
    
    public void saveShopMateriel(List<ShopMateriel> shopMateriel);
    
    public List<ShopMateriel> queryShopMaterielListByShopId(Integer shopId) throws DataAccessFailureException;
}
