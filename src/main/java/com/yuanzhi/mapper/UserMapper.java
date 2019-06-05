package com.yuanzhi.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.yuanzhi.pojo.User;


public interface UserMapper {

	 User findByName(String loginName) ;



}
