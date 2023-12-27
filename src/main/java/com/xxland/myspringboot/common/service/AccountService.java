package com.xxland.myspringboot.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxland.myspringboot.domain.entity.User;
import com.xxland.myspringboot.domain.mapper.UserMapper;

@Service
public class AccountService {

	@Autowired
	UserMapper userMapper;
	
	public User getUserSignIn(String email, String password) {
		// TODO 自動生成されたメソッド・スタブ
		User user = userMapper.selectUserBySignIn(email, password);
		
		return user;
	}

}
