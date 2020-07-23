package com.snails.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket buildDocket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(buildApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.snails.swagger.controller"))
                .paths(PathSelectors.any()).build();
    }

    public ApiInfo buildApiInfo(){
        return new ApiInfoBuilder().title("系统RESTful API文档")
                .description("更多Spring Boot相关文章请关注：http://bilibili.com/")
                .termsOfServiceUrl("http://127.0.0.1:8080/")
                .contact(new Contact("snails","http://127.0.0.1:8080/","202292735@qq.com"))
                .version("1.0").build();
    }
}
