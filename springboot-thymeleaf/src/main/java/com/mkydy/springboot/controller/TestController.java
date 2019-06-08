package com.mkydy.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/test")
	public String testThymeleaf(ModelMap modelMap) {
		modelMap.addAttribute("msg", "Hello mkydy, this is thymeleaf");
		return "thymeleaf";
	}
}
