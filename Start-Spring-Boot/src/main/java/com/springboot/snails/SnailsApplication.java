package com.springboot.snails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SnailsApplication {

    @RequestMapping("/")
    String index(){
        return "Hello World,String Boot!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SnailsApplication.class, args);
    }

}
