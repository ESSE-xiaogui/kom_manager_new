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

import com.transsion.store.bo.ShopExtension;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import org.apache.ibatis.annotations.Param;

public interface ShopExtensionMapper extends GenericIBatisMapper<ShopExtension, java.lang.Long> {

    public List<ShopExtension> listPaginationByProperty(Pagination<ShopExtension> pagination, @Param("shopExtension")ShopExtension shopExtension, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
    
    public ShopExtension queryShopExtensionByShopId(Long shopId) throws DataAccessFailureException;
}
