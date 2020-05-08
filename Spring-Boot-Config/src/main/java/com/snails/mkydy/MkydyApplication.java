package com.snails.mkydy;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.snails.mkydy")
public class MkydyApplication {
    public MkydyApplication(){
    }
    public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(MkydyApplication.class);
//        app.setBannerMode(Banner.Mode.OFF);
//        app.run(args);
        SpringApplication.run(MkydyApplication.class,args);
    }

}
