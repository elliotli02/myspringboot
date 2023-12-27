package com.xxland.myspringboot.domain.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.xxland.myspringboot.domain.entity.User;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String userEmail);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userEmail);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
	User selectUserBySignIn(String userEmail, String userPassword);

}