package com.snails.mybatis.controller;

import com.snails.mybatis.bean.SysUser;
import com.snails.mybatis.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/query")
    public SysUser testQuery(){
        return sysUserService.selectSysUserByName("mkydy");
    }

    @RequestMapping("/insert")
    public List<SysUser> testInsert(){
        sysUserService.insertSysUser();
        return sysUserService.selectAllUser();
    }

    @RequestMapping("/changeMoney")
    public List<SysUser> testChangeMoney(){
        sysUserService.changeMoney();
        return sysUserService.selectAllUser();
    }

    @RequestMapping("/delete")
    public String testDelete(){
        sysUserService.deleteSysUserById(6);
        return "ok";
    }


}
