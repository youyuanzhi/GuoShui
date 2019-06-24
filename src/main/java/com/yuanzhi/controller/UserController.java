package com.yuanzhi.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;
import com.yuanzhi.pojo.Info;
import com.yuanzhi.pojo.User;
import com.yuanzhi.serivce.InfoService;
import com.yuanzhi.serivce.UserService;

@Controller
public class UserController {

	@Autowired
	UserService UserService;
	
	@Autowired
	InfoService infoService;
	
	@RequestMapping("/getUsers")
	public User getUsers(String username) {
		return UserService.findByName(username);
	}
	
	@RequestMapping(value="/login")
	public String login() {
		return "loginUI";
	}
	
	/**
	 * 
	 * @param redirectAttributes
	 * @return
	 */
	
	@RequestMapping("/loginout")
	public String loginout(RedirectAttributes redirectAttributes) {
		SecurityUtils.getSubject().logout();
		redirectAttributes.addAttribute("msg","您已经安全退出");
		return "redirect:/login";
	}
	
	@RequestMapping(value="/login1")
	public String login1(String name,String password,RedirectAttributes redirectAttributes,HttpSession session) {
		//使用权限工具进行用户登录，一旦login登录成功，和return就无关了，自动跳转到shiro中配置的successUrl中的路径
		try {
			SecurityUtils.getSubject().login(new UsernamePasswordToken(name,password));
			session.setAttribute("username", name);
			return "redirect:/gzzy";			
		} catch (Exception e) {
			redirectAttributes.addAttribute("msg","用户名或密码错误");
			return "redirect:/login";
		}
		
	}
	
	
	
	@RequestMapping("/403")
	public String login403(){
		return "noPermissionUI";
	}
	
	@RequestMapping("/gzzy")
	public String user(HttpSession session) {
		String name = (String) session.getAttribute("username");
		//获取当前个人信息
		User user =UserService.findByName(name);
		session.setAttribute("user", user);
		//获取当前用户公告
		
		List<Info> infos=infoService.getAllInfo();
		
		System.out.println(infos);
		
		session.setAttribute("infos", infos);
		//PageInfo<Info> pageInfo = new PageInfo<>()
		return "home/home";
	}
	
}
