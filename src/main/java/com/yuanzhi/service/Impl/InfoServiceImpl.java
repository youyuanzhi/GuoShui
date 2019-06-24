package com.yuanzhi.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanzhi.mapper.InfoMapper;
import com.yuanzhi.pojo.Info;
import com.yuanzhi.serivce.InfoService;

@Service
public class InfoServiceImpl implements InfoService {
	@Autowired
	InfoMapper infoMapper;

	@Override
	public List<Info> getAllInfo() {
		// TODO Auto-generated method stub
		return infoMapper.getAllInfo();
	}

	
	@Override
	public Info showInfoOne(String infoId) {
		// TODO Auto-generated method stub
		return infoMapper.showInfoOne(infoId);
	}
	

}
