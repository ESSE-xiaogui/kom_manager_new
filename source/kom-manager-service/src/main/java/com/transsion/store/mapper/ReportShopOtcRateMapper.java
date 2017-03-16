/**
 * COPYRIGHT (C) 2017 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-3-16 14:43:27
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

import com.transsion.store.bo.ReportShopOtcRate;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import org.apache.ibatis.annotations.Param;

public interface ReportShopOtcRateMapper extends GenericIBatisMapper<ReportShopOtcRate, java.lang.Long> {

    public List<ReportShopOtcRate> listPaginationByProperty(Pagination<ReportShopOtcRate> pagination, @Param("reportShopOtcRate")ReportShopOtcRate reportShopOtcRate, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
}
