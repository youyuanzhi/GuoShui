package com.yuanzhi.pojo;

public class Privilege {
	private String code;
	//一个权限对应一个角色
	private String role_id;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	@Override
	public String toString() {
		return "Privilege [code=" + code + ", role_id=" + role_id + "]";
	}
	
}
