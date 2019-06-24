package com.yuanzhi.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.yuanzhi.pojo.User;

public class PoiUserUtil {
	
	public static Workbook export(List<User> users){
//		创建工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
//		创建工作表
		HSSFSheet sheet = workbook.createSheet();
//		创建第一行用于写每列的名称
		HSSFRow rowName = sheet.createRow(0);
//		创建第一行的每列的列名
		rowName.createCell(0).setCellValue("用户id");
		rowName.createCell(1).setCellValue("用户名");
		rowName.createCell(2).setCellValue("账号");
		rowName.createCell(3).setCellValue("所属部门");
		rowName.createCell(4).setCellValue("性别");
		rowName.createCell(5).setCellValue("电子邮箱");
		rowName.createCell(6).setCellValue("状态");
		
		
		for(int i = 1 ; i <= users.size() ; i ++ ){
//			创建行
			HSSFRow row = sheet.createRow(i);
			
			row.createCell(0).setCellValue(""+users.get(i-1).getId());
			row.createCell(1).setCellValue(""+users.get(i-1).getName());
			row.createCell(2).setCellValue(""+users.get(i-1).getAccount());
			row.createCell(3).setCellValue(""+users.get(i-1).getDept());
			row.createCell(4).setCellValue(""+(users.get(i-1).isGender()? '男':'女'));
			row.createCell(5).setCellValue(""+users.get(i-1).getEmail());
			row.createCell(6).setCellValue(""+users.get(i-1).getState());
		}
		
		return workbook;
		
	}
	
	public static List<User> importFile(MultipartFile file) throws Exception{
		InputStream in = file.getInputStream();
		String name = file.getOriginalFilename();
		Workbook workbook = null ;
//		根据后缀创建工作簿
		if( name.endsWith(".xls") ){
			workbook = new HSSFWorkbook(in);
		}else {
			workbook = new XSSFWorkbook(in);
		}
//		获取第一个工作表
		Sheet sheet =  workbook.getSheetAt(0);
//		判断当前工作表列数是否对应数据库位数；
		if(sheet.getRow(0).getPhysicalNumberOfCells() != 7 ){
			return null ;
		}
		List<User> users = new ArrayList<>();
//		获取当前表中的全部行
		for(int i = 1 ; i < sheet.getPhysicalNumberOfRows() ; i ++){
			User user = new User();
			user.setId(sheet.getRow(i).getCell(0).getStringCellValue());
			user.setName(sheet.getRow(i).getCell(1).getStringCellValue());
			user.setAccount(sheet.getRow(i).getCell(2).getStringCellValue());
			user.setDept(sheet.getRow(i).getCell(3).getStringCellValue());
			user.setGender((sheet.getRow(i).getCell(4).getStringCellValue().equals("男")? true : false));
			user.setEmail(sheet.getRow(i).getCell(5).getStringCellValue());
			user.setState(sheet.getRow(i).getCell(6).getStringCellValue());
			users.add(user);
		}
		
		return users;
	}
}
