package com.wechat.commons.dao;

import com.wechat.commons.entity.User;

public interface UserMapper {
	
	int deleteByPrimaryKey(Long id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
}
