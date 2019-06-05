package com.yuanzhi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanzhi.mapper.UserMapper;
import com.yuanzhi.pojo.User;
import com.yuanzhi.serivce.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userMapper;

	@Override
	public User findByName(String loginName) {
		// TODO Auto-generated method stub
		if(loginName != null && !loginName.trim().equals("")) {
			return userMapper.findByName(loginName);
		}else {
			
			return null;
		}
	}
	
	
	
}
