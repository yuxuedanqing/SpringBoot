package com.mkydy.springboot.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 	功能描述: 在ShiroConfig中做什么事情呢？
 * 1 配置shiro安全管理器，向安全管理器中注入Realm域
 * 2 配置Realm域：注入密码比较器
 * 3 配置密码比较器
 * 4 配置拦截路径和放行路径
 * @ClassName ShiroConfig
 * @Description: Shiro配置类  
 * @author: Hll  
 * @since: 2019年6月22日 下午10:04:27
 */
@Configuration
public class ShiroConfig {
	
	/**
	 * 
	 * @Description： 创建ShiroFilterFactoryBean
	 * @author: Hll 
	 * @since: 2019年6月22日 下午10:31:16
	 */
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		// 设置安全管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		/**
		 * 添加shiro内置过滤器，可以实现权限相关的拦截器
		 * 常用过滤器：
		 * 	anon：无需认证（登录）可以访问
		 * 	authc：必须认证才可以访问
		 * 	user：如果使用rememberMe的功能可以直接访问
		 * 	perms：该资源必须的到资源权限才可以访问
		 * 	role：该资源必须得到角色权限才可以访问
		 */
		Map<String,String> linkedHashMap = new LinkedHashMap<>();
//		linkedHashMap.put("/addUser","authc");
//		linkedHashMap.put("/updateUser","authc");
		/**
		 * 放行该请求
		 */
		linkedHashMap.put("/testThymeleaf", "anon");
		/**
		 * 使请求某路径下的所有资源都用统一过滤
		 */
		linkedHashMap.put("/*","authc");
		/**
		 * 修改拦截后跳转的页面
		 */
		shiroFilterFactoryBean.setLoginUrl("/toLogin");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(linkedHashMap);
		return shiroFilterFactoryBean;
	}

	/**
	 * 
	 * @Description： 创建DefaultWebSecurityManager
	 * @author: Hll 
	 * @since: 2019年6月22日 下午10:25:00
	 */
	@Bean(name="securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("shiroRealm")ShiroRealm shiroRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 关联realm
		securityManager.setRealm(shiroRealm);
		return securityManager;
	}
	
	/**
	 * 
	 * @Description： 创建Realm
	 * @author: Hll 
	 * @since: 2019年6月22日 下午10:16:22
	 */
	@Bean(name="shiroRealm")
	public ShiroRealm getRealm() {
		return new ShiroRealm();
	}
	
	
	
	
}
