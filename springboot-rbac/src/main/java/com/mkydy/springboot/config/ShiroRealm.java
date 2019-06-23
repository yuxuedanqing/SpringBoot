package com.mkydy.springboot.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
/**
 * 
 * @ClassName ShiroRealm
 * @Description: 自定义Realm  
 * @author: Hll  
 * @since: 2019年6月22日 下午10:12:56
 */
public class ShiroRealm extends AuthorizingRealm {

	/**
	 * 执行授权逻辑
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("执行授权逻辑");
		return null;
	}

	/**
	 * 执行认证逻辑
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("执行认证逻辑");
		
		/**
		 * 假设数据库的用户名和密码
		 */
		String name = "mkydy";
		String password = "123456";
		UsernamePasswordToken tok = (UsernamePasswordToken)token;
		if(!tok.getUsername().equals(name)) {
			return null;
		}
		return new SimpleAuthenticationInfo("", password, "");
	}

}
