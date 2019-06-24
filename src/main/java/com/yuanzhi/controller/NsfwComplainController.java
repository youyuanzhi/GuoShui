package com.yuanzhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuanzhi.serivce.NsfwComplainService;
import com.yuanzhi.util.ResultUtil;

@RequestMapping("/nsfw/complain")
@Controller
public class NsfwComplainController {

	@Autowired
	NsfwComplainService NnsfwComplainService;
	
	@RequestMapping("listUI")
	public String listUI() {
		return "nsfw/complain/listUI";
	}
	
	@RequestMapping("annualStatisticChartUI")
	public String annualStatisticChartUI() {
		return "nsfw/complain/annualStatisticChartUI";
	}
	
	@RequestMapping("/complainGetAnnualStatisticData")
	@ResponseBody
	public ResultUtil complainGetAnnualStatisticData(Integer year) {
		return NnsfwComplainService.complainGetAnnualStatisticData(year);
	}
}
