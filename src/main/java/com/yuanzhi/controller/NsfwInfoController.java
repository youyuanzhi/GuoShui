package com.yuanzhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nsfw/info")
public class NsfwInfoController {
	
	@RequestMapping("/listUI")
	public String listUI() {
		return "/nsfw/info/listUI";
	}
}
