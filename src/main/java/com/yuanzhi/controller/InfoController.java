package com.yuanzhi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuanzhi.pojo.Info;
import com.yuanzhi.serivce.InfoService;

@Controller
public class InfoController {
	
	@Autowired
	InfoService infoService;
	
	@RequestMapping("/gzzy/showInfoOne")
	public String showInfoOne(String infoId,HttpSession session) {
	Info info=	infoService.showInfoOne(infoId);
	System.out.println(infoId);
	session.setAttribute("infoOne", info);
	return "/home/infoViewUI";
	}
}
