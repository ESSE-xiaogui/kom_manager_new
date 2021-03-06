/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 17:33:07
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

import com.transsion.store.bo.Company;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;

import org.apache.ibatis.annotations.Param;

public interface CompanyMapper extends GenericIBatisMapper<Company, java.lang.Long> {

    public List<Company> listPaginationByProperty(Pagination<Company> pagination, @Param("company")Company company, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
    public List<Company> findAll() throws DataAccessFailureException;
}
