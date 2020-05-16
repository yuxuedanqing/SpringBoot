package com.snails.aop.controller;

import com.snails.aop.annotation.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Log("执行方法一")
    @GetMapping(value = "/one")
    public void methodOne(String name){}

    @Log("执行方法二")
    @GetMapping(value = "/two")
    public void methodTwo() throws InterruptedException{
        Thread.sleep(2000);
    }

    @Log("执行方法三")
    @GetMapping(value = "/three")
    public void methodThree(String name,String age){}
}
