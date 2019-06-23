package com.mkydy.springboot.config;

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
	
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		// 设置安全管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager);
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
	@Bean
	public ShiroRealm getRealm() {
		return new ShiroRealm();
	}
	
}
