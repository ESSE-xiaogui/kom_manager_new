/**
 * COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-3-1 16:30:39
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
import com.transsion.store.bo.GoalModel;
import com.transsion.store.dto.StatShopModelSaleDto;

public interface GoalModelMapper extends GenericIBatisMapper<GoalModel, java.lang.Long> {

    public List<GoalModel> listPaginationByProperty(Pagination<GoalModel> pagination, @Param("goalModel")GoalModel goalModel, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
    
    public List<StatShopModelSaleDto> queryModelSaleTargetByShopId(@Param("shopId")Long shopId, @Param("goalMonth")String goalMonth, @Param("modelCodeList")List<String> modelCodeList) throws DataAccessFailureException;
    
    public List<Long> queryShopIdListByGoalMonth(String goalMonth);
    
    public List<GoalModel> queryModelCodeListByShopId(Long shopId);
    
    public void updateGoalModelByShopId(GoalModel goalModel);
}
