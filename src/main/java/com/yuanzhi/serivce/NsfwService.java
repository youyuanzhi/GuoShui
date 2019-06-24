package com.yuanzhi.serivce;

import java.util.List;

import com.yuanzhi.pojo.Role;

public interface NsfwService {

	List<Role> selectAllRoles();

	int selectRoleByName(String roleName);

	int role_addRole(String name, String[] privilege, String state);

	Role roleEditUI(String id);

	int roleEditRole(String role_id, String name, String[] privilege, String state);

	
}
