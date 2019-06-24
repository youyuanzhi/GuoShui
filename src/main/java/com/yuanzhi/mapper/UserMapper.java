package com.yuanzhi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yuanzhi.pojo.Info;
import com.yuanzhi.pojo.User;


public interface UserMapper {

	 User findByName(String loginName) ;





}
