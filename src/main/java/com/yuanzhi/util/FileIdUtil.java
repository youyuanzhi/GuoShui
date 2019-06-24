package com.yuanzhi.util;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;

public class FileIdUtil {
	
	public static String getId(){
		Date date = new Date();
		long dateTime = date.getTime();
		String id = (""+dateTime).substring(6) ;
		String uuid = UUID.randomUUID().toString();
		return id + uuid.substring(uuid.lastIndexOf("-"));
	}
	
	@Test
	public void test1(){
		System.out.println(UUID.randomUUID());
	}
	
}
