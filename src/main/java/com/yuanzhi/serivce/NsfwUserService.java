package com.yuanzhi.serivce;

import java.util.List;

import com.yuanzhi.pojo.User;

public interface NsfwUserService {

	List<User> userListUI();

	void addBatch(List<User> users);

}
