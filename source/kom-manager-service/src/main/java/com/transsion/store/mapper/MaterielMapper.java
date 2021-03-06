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

import org.apache.ibatis.annotations.Param;

import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.transsion.store.bo.Materiel;
import com.transsion.store.dto.MaterialInfoDto;

public interface MaterielMapper extends GenericIBatisMapper<Materiel, java.lang.Long> {

    public List<Materiel> listPaginationByProperty(Pagination<Materiel> pagination, @Param("materiel")Materiel materiel, @Param("orderBy") Map<String, String> orderBy, @Param("companyId")Long companyId) throws DataAccessFailureException;

    public List<MaterialInfoDto> findMateriel(@Param("companyId")Long companyId) throws DataAccessFailureException;
}
