package com.yuanzhi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuanzhi.pojo.Role;

public interface NsfwMapper {

	List<Role> selectAllRoles();

	int selectRoleByName(String roleName);

	int addRole(@Param("id")String id, @Param("name")String name, @Param("state")String state);

	int addRolePrivilege(@Param("roleId")String id, @Param("privilege")String string);

	Role roleEditUI(String id);

	int roleEditRole(@Param("id")String role_id, @Param("name")String name,@Param("state") String state);

	int deletePrivilege(String role_id);

}
