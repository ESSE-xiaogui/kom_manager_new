/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 17:33:08
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

import com.transsion.store.bo.Model;
import com.transsion.store.dto.ModelDto;
import com.transsion.store.dto.ModelListDto;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import com.shangkang.core.exception.ServiceException;

import org.apache.ibatis.annotations.Param;

public interface ModelMapper extends GenericIBatisMapper<Model, java.lang.Long> {

    public List<ModelListDto> listPaginationByProperty(Pagination<ModelListDto> pagination, @Param("modelListDto")ModelListDto modelListDto, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
    public List<ModelDto> findModel (Model model) throws DataAccessFailureException;
    public List<String> findModelName(@Param("companyId") Long companyId) throws ServiceException;
}
