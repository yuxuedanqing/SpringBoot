package com.mkydy.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 
 * @ClassName HelloController
 * @Description: 测试controller  
 * @author: Hll  
 * @since: 2019年6月22日 下午9:40:02
 */
@Controller
public class HelloController {

	/**
	 * 
	 * @Description： 测试首页访问
	 * @author: Hll 
	 * @since: 2019年6月22日 下午9:40:45
	 */
	@RequestMapping(value= {"/", "/index"})
	@ResponseBody
	public String hello() {
		return "<h1>Hello World!</h1>";
	}
	
	@RequestMapping("/testThymeleaf")
	public String testThymeleaf(Model model) {
		model.addAttribute("name", "硝酸银");
		return "test";
	}
	
	/**
	 * 
	 * @Description： 用户添加
	 * @author: Hll 
	 * @since: 2019年6月23日 上午9:24:58
	 */
	@GetMapping(value= "/addUser")
	public String addUser() {
		return "user/addUser";
	}
	
	/**
	 * 
	 * @Description： 用户修改
	 * @author: Hll 
	 * @since: 2019年6月23日 上午9:25:15
	 */
	@GetMapping(value= "/updateUser")
	public String updateUser() {
		return "user/updateUser";
	}
	
	@GetMapping(value="/toLogin")
	public String login(HttpServletRequest req) {
		String name = "haha";
		String msg=(String) req.getSession().getAttribute("msg");
		System.out.println(name);
		System.out.println("美术馆：" + msg);
		return "login";
	}
	
}
