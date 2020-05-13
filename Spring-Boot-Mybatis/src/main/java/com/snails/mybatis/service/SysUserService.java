package com.snails.mybatis.service;

import com.snails.mybatis.bean.SysUser;
import com.snails.mybatis.dao.SysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysUserService {

    @Autowired
    private SysUserDao sysUserDao;


    /**
     * 根据名字查找用户
     * @param name  用户名
     * @return  <code>SysUser</code>
     */
    public SysUser selectSysUserByName(String name){
        return sysUserDao.findSysUserByName(name);
    }

    /**
     * 查找所有用户
     * @return  <code>List<SysUser></code>
     */
    public List<SysUser> selectAllUser(){
        return sysUserDao.findAllSysUser();
    }

    /**
     * 插入两个用户
     */
    public void insertSysUser(){
        sysUserDao.insertSysUser("Snails",22,3000.0);
        sysUserDao.insertSysUser("mkydy",19,3000.0);
    }

    /**
     * 根据 id 删除用户
     * @param id id
     */
    public void deleteSysUserById(int id){
        sysUserDao.deleteSysUser(id);
    }

    /**
     * 模拟事务 由于加上了 <code>@Transactional</code> 注解，如果转账途中出现了意外， snails 和 mkydy 的钱都不会改变
     */
    @Transactional
    public void changeMoney(){
        sysUserDao.updateSysUser("snails",22,2000.0,5);
        int temp = 1 / 0;
        sysUserDao.updateSysUser("mkydy",19,4000.0,6);
    }
}
