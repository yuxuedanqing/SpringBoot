package com.snails.mkydy.controller;

import com.snails.mkydy.entity.BlogProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private BlogProperties blogProperties;

    @RequestMapping("/test")
    public String index(){
        return blogProperties.getName()+"--"+blogProperties.getTitle();
    }
}
