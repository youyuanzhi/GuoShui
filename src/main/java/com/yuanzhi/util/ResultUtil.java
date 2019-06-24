package com.yuanzhi.util;

public class ResultUtil {
	private int code;
	private String msg;
	private Object object;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	
	private ResultUtil(int code) {
		this.code = code;
	}
	private ResultUtil(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	private ResultUtil(int code, String msg, Object object) {
		super();
		this.code = code;
		this.msg = msg;
		this.object = object;
	}

	//数据请求成功
	public static ResultUtil success()	{
		return new ResultUtil(1);
	}
	
	//数据请求失败
	public static ResultUtil error(String errorMsg) {
		return new ResultUtil(0,errorMsg);
	}
	
	public static ResultUtil success(String successMsg,Object object) {
		return new ResultUtil(1,successMsg,object);
	}
	
	
}
