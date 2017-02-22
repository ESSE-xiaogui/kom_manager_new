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

import com.transsion.store.bo.Organization;
import com.transsion.store.dto.OrgInfoDto;
import com.transsion.store.dto.OrganizationDto;
import com.transsion.store.dto.OrganizationResponseDto;
import com.transsion.store.dto.OrganizationTreeDto;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import org.apache.ibatis.annotations.Param;

public interface OrganizationMapper extends GenericIBatisMapper<Organization, java.lang.Long> {

    public List<OrgInfoDto> listPaginationByProperty(Pagination<OrgInfoDto> pagination, @Param("orgInfoDto")OrgInfoDto orgInfoDto, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
    public OrganizationResponseDto getOrgName(@Param("orgId") Integer orgId);
    public List<OrganizationTreeDto> findOrg(@Param("companyId") Long companyId);
    public OrganizationDto getByPKs(@Param("id") Long id) throws DataAccessFailureException;
    public OrganizationDto findOrgId(@Param("companyId") Long companyId) throws DataAccessFailureException;
}
