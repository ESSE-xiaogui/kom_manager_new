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
import com.transsion.store.bo.Prototype;
import com.transsion.store.dto.PrototypeDto;

public interface PrototypeMapper extends GenericIBatisMapper<Prototype, java.lang.Long> {

    public List<PrototypeDto> listPaginationByPropertyDto(Pagination<PrototypeDto> pagination, @Param("prototypeDto")PrototypeDto prototypeDto, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
    
    public PrototypeDto getPrototypeDtoById(Long id);
    
    public int checkImeiOnly(@Param("prototype")Prototype prototype);
}
