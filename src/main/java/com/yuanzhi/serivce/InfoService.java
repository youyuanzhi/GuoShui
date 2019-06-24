package com.yuanzhi.serivce;

import java.util.List;

import com.yuanzhi.pojo.Info;

public interface InfoService {

	List<Info> getAllInfo();


	Info showInfoOne(String infoId);

}
