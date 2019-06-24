package com.yuanzhi.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanzhi.mapper.NsfwUserMapper;
import com.yuanzhi.pojo.User;
import com.yuanzhi.serivce.NsfwUserService;

@Service
public class NsfwUserServiceImpl implements NsfwUserService {

	@Autowired
	NsfwUserMapper nsfwUserMapper;
	
	@Override
	public List<User> userListUI() {
		
		return nsfwUserMapper.userListUI();
	}

	@Override
	public void addBatch(List<User> users) {
		for(int i = 0 ;i<users.size();i++) {
			int num = nsfwUserMapper.addUser(users.get(i));
		}
	}

}
