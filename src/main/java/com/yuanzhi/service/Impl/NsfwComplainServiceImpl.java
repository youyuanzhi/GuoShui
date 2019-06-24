package com.yuanzhi.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanzhi.mapper.NsfwComplainMapper;
import com.yuanzhi.pojo.FusionCharts;
import com.yuanzhi.serivce.NsfwComplainService;
import com.yuanzhi.util.ResultUtil;

@Service
public class NsfwComplainServiceImpl implements NsfwComplainService {

	@Autowired
	NsfwComplainMapper nsfwComplainMapper;
	
	@Override
	public ResultUtil complainGetAnnualStatisticData(Integer year) {
		
		List<FusionCharts> fusionCharts = new ArrayList<>();;
		for(int i = 1 ;i<= 12 ; i++) {
			int num = nsfwComplainMapper.selectCountByMonth(year,i);
			fusionCharts.add(new FusionCharts(""+i,""+num));
			
		}
		return ResultUtil.success("",fusionCharts);
	}

}
