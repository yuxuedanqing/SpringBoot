package com.mkydy.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}
