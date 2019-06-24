package com.yuanzhi.pojo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Role {
	private String role_id;
	private String name;
	private String state;
	//一个角色对应多个权限
	
	private List<Privilege> privileges;
	private Set<String> privilegesName;
	
	
	
	public Set<String> getPrivilegesName() {
		privilegesName = new HashSet<>();
		if(privileges != null && privileges.size()>0) {
			for(Privilege privilege:privileges) {
				privilegesName.add(privilege.getCode());
			}
		}
		return privilegesName;
	}
	public void setPrivilegesName(Set<String> privilegesName) {
		this.privilegesName = privilegesName;
	}
	public List<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", name=" + name + ", state=" + state + ", privileges=" + privileges
				+ ", privilegesName=" + privilegesName + "]";
	}

}
