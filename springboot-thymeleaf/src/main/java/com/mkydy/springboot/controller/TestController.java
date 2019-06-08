package com.mkydy.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

@Controller
public class TestController {

	public String testThymeleaf(ModelMap modelMap) {
		modelMap.addAttribute("msg", "Hello mkydy, this is thymeleaf");
		return "thymeleaf";
	}
}
