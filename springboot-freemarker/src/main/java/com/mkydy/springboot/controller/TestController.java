package com.mkydy.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TestController {

	@RequestMapping("/test")
	public String testFreeMarker(ModelMap modelMap) {
		modelMap.addAttribute("msg", "Hello mkydy, this is freemarker");
		return "freemarker";
	}
}
