package com.snails.config.controller;

import com.snails.config.entity.BlogProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private BlogProperties blogProperties;

    @RequestMapping("/")
    public String index(){
        return blogProperties.getName()+"----->"+blogProperties.getTitle();
    }
}
