package com.yuanzhi.controller;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanzhi.pojo.User;
import com.yuanzhi.serivce.NsfwUserService;
import com.yuanzhi.util.ExportUserUtil;
import com.yuanzhi.util.PoiUserUtil;

@RequestMapping("/nsfw/user")
@Controller
public class NsfwUserController {
	
	@Autowired
	NsfwUserService nsfwUserService;
	
	
	@RequestMapping("/listUI")
	public String listUI(HttpSession session,@RequestParam(required=true,defaultValue="1")Integer pageNum) {
		PageHelper.startPage(pageNum,5);
		List<User> users=nsfwUserService.userListUI();
		PageInfo<User> pageInfo = new PageInfo<>(users);
		session.setAttribute("userPage", pageInfo);
		return "nsfw/user/listUI";
		}
	
	@RequestMapping("/exportExcel")
	public void exportExcel(@RequestParam(required=true , defaultValue="1") Integer pageNum , HttpServletResponse response){
		PageHelper.startPage(pageNum, 5);
		List<User> users = nsfwUserService.userListUI();
		PageInfo<User> pageInfo = new PageInfo<>(users);
		response.setContentType("application/vnd.ms-excel");
        // 传递中文参数编码
        String codedFileName;
		try {
			codedFileName = java.net.URLEncoder.encode("中文","UTF-8");
			response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xls");
	        Workbook workbook = ExportUserUtil.export(users);
	        OutputStream  fOut = response.getOutputStream();
	        workbook.write(fOut); 
	        fOut.flush();  
	        fOut.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@RequestMapping("/importExcel")
	public String importExcel(MultipartFile file,HttpServletRequest request){	
		try {
			List<User> users = PoiUserUtil.importFile(file);
			System.out.println(users);
			if(users == null || users.size() < 1){
				request.setAttribute("addUsersErrorMsg", "导入文件格式不正确");
				return "error";
			}
			nsfwUserService.addBatch(users);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "nsfw/user/listUI";
	}

}
