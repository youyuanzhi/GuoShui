package com.yuanzhi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.core.tools.picocli.CommandLine.Parameters;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionAttributeStore;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanzhi.pojo.Role;
import com.yuanzhi.serivce.NsfwService;
import com.yuanzhi.util.ResultUtil;

@Controller
@RequestMapping("/nsfw")
public class NsfwController {

	@Autowired
	NsfwService nsfwService;
	
	@RequestMapping("/frame")
	public String frame() {	
		return "nsfw/frame";
	}
	@RequestMapping("/home_top")
	public String home_top() {	
		return "nsfw/top";
	}
	@RequestMapping("/home_left")
	public String home_left() {	
		return "nsfw/left";
	}
	
	@RequestMapping("/role/listUI")
	
	public String role_listUI(HttpSession session ,@RequestParam(required=true,defaultValue="1")Integer page) {
		PageHelper.startPage(page,5);
		List<Role> roles= nsfwService.selectAllRoles();
		PageInfo<Role> pageInfo = new PageInfo<>(roles,5);
		pageInfo.setPageNum(page);
		
		pageInfo.setPageSize(5);
		session.setAttribute("page", pageInfo);
//		session.setAttribute("nsfwRoles", roles);
		return "nsfw/role/listUI";
	}
	
	
	@RequestMapping("/role/addUI")
	public String role_addUI() {	
		return "nsfw/role/addUI";
	}
	
	
	@RequestMapping("/role/addRole")
	public String role_addRole(String name,String [] privilege,String state){
		int num = nsfwService.role_addRole(name,privilege,state);
		if(num>0) {
			return "nsfw/role/listUI";
		}else {			
			return "nsfw/role/addUI";
		}
	}
	
	
	
	
	@RequestMapping("/role/getRoleNames")
	@ResponseBody
	public ResultUtil role_getRoleNames(String roleName) {	
		int num=nsfwService.selectRoleByName(roleName);
		if(num > 0 || roleName==null || roleName.trim().equals("")) {
			return ResultUtil.error("当前角色不可创建");
		}else {
			return ResultUtil.success("当前角色可以创建",null);
		}
	}

	@RequestMapping("/role/editUI")
	public String roleEditUI(String id,HttpSession session) {	
		Role role=nsfwService.roleEditUI(id);
		session.setAttribute("roleEdit", role);
		return "nsfw/role/editUI";
	}
	
	@RequestMapping("/role/editRole")
	public String roleEditRole(String role_id,String name,String [] privilege,String state) {
		System.out.println("=================="+role_id+name+privilege.length+state);
//		System.out.println(role_id);
//		System.out.println(name);
//		System.out.println(privilege.length);
//		System.out.println(state);
		int num = nsfwService.roleEditRole(role_id,name,privilege,state);
		if(num > 0) {
			return "nsfw/role/listUI";
		}else {
			return "nsfw/role/editUI";
		}
	}
	

}
