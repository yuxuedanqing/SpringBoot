# SpringBoot
Spring Boot 学习入门

##  :hammer_and_wrench: 开发环境

+ Eclipse4.9.0
+ Jdk1.8
+ Maven3.6.0
+ Spring Boot 2.1.5.RELEASE
+ STS插件

## 项目结构

Spring Boot框架对工程结构并没有什么特殊的限制,只是良好的工程结构划分可以使项目更清晰,明确,减少不必要的冲突,提高代码的统一性.

推荐工程结构示例：

> 代码层的结构

**根目录：com.springboot**

1.工程启动类(ApplicationServer.java)置于com.springboot.build包下

2.实体类(domain)置于com.springboot.domain

3.数据访问层(Dao)置于com.springboot.repository

4.数据服务层(Service)置于com,springboot.service,数据服务的实现接口(serviceImpl)至于com.springboot.service.impl

5.前端控制器(Controller)置于com.springboot.controller

6.工具类(utils)置于com.springboot.utils

7.常量接口类(constant)置于com.springboot.constant

8.配置信息类(config)置于com.springboot.config

9.数据传输类(vo)置于com.springboot.vo

> 资源文件的结构

**根目录:src/main/resources**

1.配置文件(.properties/.json等)置于config文件夹下

2.国际化(i18n))置于i18n文件夹下

3.spring.xml置于META-INF/spring文件夹下

4.页面以及js/css/image等置于static文件夹下的各自文件下