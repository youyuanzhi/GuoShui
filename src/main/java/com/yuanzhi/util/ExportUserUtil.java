package com.yuanzhi.util;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import com.yuanzhi.pojo.User;

public class ExportUserUtil {

	public static Workbook export(List<User> users) {
		//创建工作簿
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
}

