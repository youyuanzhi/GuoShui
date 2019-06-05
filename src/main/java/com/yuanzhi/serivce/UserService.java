package com.yuanzhi.serivce;

import com.yuanzhi.pojo.User;

public interface UserService {

	User findByName(String loginName);
	
}
