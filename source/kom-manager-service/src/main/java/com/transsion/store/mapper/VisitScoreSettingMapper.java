/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2017-2-21 10:24:48
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

import com.transsion.store.bo.VisitScoreSetting;
import com.transsion.store.dto.VisitScoreSettingDetailDto;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import org.apache.ibatis.annotations.Param;

public interface VisitScoreSettingMapper extends GenericIBatisMapper<VisitScoreSetting, java.lang.Long> {

    public List<VisitScoreSettingDetailDto> listPaginationByProperty(Pagination<VisitScoreSettingDetailDto> pagination, @Param("visitScoreSettingDetailDto")VisitScoreSettingDetailDto visitScoreSettingDetailDto, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
}
