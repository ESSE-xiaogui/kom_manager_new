/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 17:33:12
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
import com.transsion.store.bo.StockItem;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import org.apache.ibatis.annotations.Param;

public interface StockItemMapper extends GenericIBatisMapper<StockItem, java.lang.Long> {

    public List<StockItem> listPaginationByProperty(Pagination<StockItem> pagination, @Param("stockItem")StockItem stockItem, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
    public int updateByHistory(@Param("brandCode")String brandCode,@Param("modelCode")String modelCode, @Param("userId")String userId);
    public void saveStockDetailUpload(List<StockItem> stockItemList);


}
