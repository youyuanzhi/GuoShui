package com.yuanzhi.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanzhi.mapper.NsfwMapper;
import com.yuanzhi.pojo.Role;
import com.yuanzhi.serivce.NsfwService;
import com.yuanzhi.util.FileIdUtil;

@Service
public class NsfwServiceImpl implements NsfwService {

	@Autowired
	NsfwMapper nsfwMapper;
	
	
	@Override
	public List<Role> selectAllRoles() {
		
		return nsfwMapper.selectAllRoles();
	}


	@Override
	public int selectRoleByName(String roleName) {
		
		return nsfwMapper.selectRoleByName(roleName);
	}


	@Override
	public int role_addRole(String name, String[] privilege, String state) {
		String id = FileIdUtil.getId();
		int num = nsfwMapper.addRole(id,name,state);
		if(num > 0) {
			for(int i=0;i<privilege.length;i++) {
				int num1 = nsfwMapper.addRolePrivilege(id,privilege[i]);
			}
			return 1;
		}
		return 0;
	}


	@Override
	public Role roleEditUI(String id) {
		
		return nsfwMapper.roleEditUI(id);
	}


	@Override
	public int roleEditRole(String role_id, String name, String[] privilege, String state) {
		System.out.println("进入serviceImpl.roleEditRole");
		int num = nsfwMapper.roleEditRole(role_id,name,state);
		if(num > 0) {
			int num2=nsfwMapper.deletePrivilege(role_id);
			for(int i =0;i< privilege.length;i++) {
				int num1 = nsfwMapper.addRolePrivilege(role_id,privilege[i]);
			}
			return 1;
		}
		return 0;
	}


	

}
