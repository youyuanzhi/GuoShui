package com.yuanzhi.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanzhi.mapper.UserMapper;
import com.yuanzhi.pojo.User;
import com.yuanzhi.serivce.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper ;

	public User findByName(String loginName) {
		if(loginName != null && !loginName.trim().equals("")){
			return userMapper.findByName(loginName);
		}else{
			return null ;
		}
}
}
