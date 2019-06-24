package com.yuanzhi.mapper;

import java.util.List;

import com.yuanzhi.pojo.User;

public interface NsfwUserMapper {

	List<User> userListUI();

	int addUser(User user);

}
