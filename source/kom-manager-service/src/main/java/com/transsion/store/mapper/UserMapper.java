/**
 * COPYRIGHT (C) 2016 Liuzh. ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system,
 * or transmitted, on any form or by any means, electronic, mechanical, photocopying,
 * recording, or otherwise, without the prior written permission of Liuzh.
 *
 * Created By: Liuzh
 * Created On: 2016-11-18 17:33:13
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

import com.transsion.store.bo.User;
import com.transsion.store.dto.UserDto;
import com.transsion.store.dto.UserInfoDto;
import com.transsion.store.dto.UserResponseDto;
import com.shangkang.core.mapper.GenericIBatisMapper;
import com.shangkang.core.bo.Pagination;
import com.shangkang.core.exception.DataAccessFailureException;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends GenericIBatisMapper<User, java.lang.Long> {

	public List<User> listPaginationByProperty(Pagination<User> pagination, @Param("user")User user, @Param("orderBy") Map<String, String> orderBy) throws DataAccessFailureException;
	      
    public UserDto findByName(@Param("userCode")String userCode) throws DataAccessFailureException;
	
    public UserInfoDto getUserInfo(UserInfoDto userInfoDto) throws DataAccessFailureException;
	
	public UserResponseDto getUser(User user) throws DataAccessFailureException;
	
	public void updateLastLogin(User user)throws DataAccessFailureException;

}
