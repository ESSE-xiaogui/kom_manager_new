/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-5-25 11:40:37
 *
 * Amendment History:
 * 
 * Amended By       Amended On      Amendment Description
 * ------------     -----------     ---------------------------------------------
 *
 **/
package com.transsion.store.mapper;

import java.util.List;

import com.shangkang.core.mapper.GenericIBatisMapper;
import com.transsion.store.bo.Currency;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import org.apache.ibatis.annotations.Param;

public interface CurrencyMapper extends GenericIBatisMapper<Currency, java.lang.Long> {

	public List<Currency> listPaginationByProperty(Pagination<Currency> pagination, Currency currency) throws DataAccessFailureException;

	public java.math.BigDecimal queryCurrencyRatio(@Param("dealerId") Integer dealerId,@Param("companyId") Integer companyId);
}
