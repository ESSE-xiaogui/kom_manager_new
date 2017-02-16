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

import com.transsion.store.bo.ShopBiz;
import com.transsion.store.dto.ShopBizDto;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import org.apache.ibatis.annotations.Param;

public interface ShopBizMapper extends GenericIBatisMapper<ShopBiz, java.lang.Long> {

    public List<ShopBizDto> listPaginationByProperty(Pagination<ShopBizDto> pagination, @Param("shopBizDto")ShopBizDto shopBizDto, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
    public ShopBiz findShopBiz(@QueryParam("saleId") Long saleId);

}
