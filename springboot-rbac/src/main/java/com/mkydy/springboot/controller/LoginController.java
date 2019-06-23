package com.mkydy.springboot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @ClassName LoginController
 * @Description: 处理登陆  
 * @author: Hll  
 * @since: 2019年6月23日 上午10:07:33
 */
@Controller
public class LoginController {

	/**
	 * 
	 * @Description： 处理登陆逻辑
	 * @author: Hll 
	 * @since: 2019年6月23日 上午10:08:11
	 */
	@RequestMapping(value="/login",produces= {"application/UTF-8"})
	public ModelAndView login(String name,String password) {
		System.out.println(name);
		ModelAndView view = new ModelAndView();
		/**
		 * 使用shiro编写认证操作
		 */
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(name, password);
		try {
			subject.login(token);
			view.setViewName("test");
			return view;
		} catch (UnknownAccountException e) {
			// TODO: 用户名不存在
			
			view.addObject("msg", "用户名不存在");
			view.setViewName("login");
			return view;
		} catch (IncorrectCredentialsException e) {
			// TODO: 密码不对
			view.addObject("msg", "密码不对");
			view.setViewName("login");
			return view;
		}
	}
}
