package com.yuanzhi.mapper;

import java.util.List;

import com.yuanzhi.pojo.Info;

public interface InfoMapper {

	public List<Info> getAllInfo();

	public Info showInfoOne(String infoId);

}
