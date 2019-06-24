package com.yuanzhi.util;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yuanzhi.pojo.Role;
import com.yuanzhi.pojo.User;
import com.yuanzhi.serivce.UserService;



public class MyShiro extends AuthorizingRealm{

	@Autowired
	UserService userService;
	
	//认证权限
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		//获取时输入的用户名
		String loginName=(String) principalCollection.fromRealm(getName()).iterator().next();
		//检查数据库中是否存在该用户
		User user=userService.findByName(loginName);
		if(user != null) {
		//使用权限信息对象来存放查看用户角色及权限
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			//查询用户角色
			info.setRoles(user.getRolesName());
			//通过角色得到用户的权限，
			List<Role> roles = user.getRoles();
			System.out.println("user"+user.getRolesName());
			for(Role role : roles) {
				info.addStringPermissions(role.getPrivilegesName());
				System.out.println(role.getPrivilegesName());
			}
			return info;
		}
		return null;
	}

	//登录认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		// TODO Auto-generated method stub
		//使用token保存提交的登录信息
		UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
		User user=userService.findByName(token.getUsername());
		System.out.println("user:" + user);
		if(user!=null) {
			//若存在该用户则存到
			return new SimpleAuthenticationInfo(user.getName(),user.getPassword(),getName());
		}
		return null;
	}

}
