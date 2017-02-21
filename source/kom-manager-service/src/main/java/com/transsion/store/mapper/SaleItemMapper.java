/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 17:33:10
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

import com.transsion.store.bo.SaleItem;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import org.apache.ibatis.annotations.Param;

public interface SaleItemMapper extends GenericIBatisMapper<SaleItem, java.lang.Long> {

    public List<SaleItem> listPaginationByProperty(Pagination<SaleItem> pagination, @Param("saleItem")SaleItem saleItem, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
    public String queryScanDuplicatedIMEI(@Param("imei") String imei);
    public void saveSaleItem(List<SaleItem> tShopSaleitem);
    
    public List<String> queryImeiNoList(List<String> imeiList);

}
