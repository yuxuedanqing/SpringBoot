package com.snails.mybatis.dao;

import com.snails.mybatis.bean.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SysUserDao {

    /**
     * 通过名字查找用户信息
     * @param name 用户名
     * @return 用户对象
     */
    @Select("select * from sys_user where name = #{name}")
    SysUser findSysUserByName(@Param("name") String name);

    /**
     * 查询用户所有信息
     * @return 用户集合
     */
    @Select("select * from sys_user")
    List<SysUser> findAllSysUser();

    /**
     * 插入用户信息
     * @param name 姓名
     * @param age 年龄
     * @param money 金钱
     */
    @Insert("insert into sys_user(name,age,money) values(#{name},#{age},#{money})")
    void insertSysUser(@Param("name") String name,@Param("age") Integer age,@Param("money") Double money);

    /**
     * 根据 id 更新用户信息
     * @param name 用户名
     * @param age   年龄
     * @param money 金钱
     * @param id    id
     */
    @Update("update sys_user set name = #{name}, age = #{age}, money = #{money} where id = #{id}")
    void updateSysUser(@Param("name") String name,@Param("age") Integer age,@Param("money") Double money,
                       @Param("id") int id);

    @Delete("delete from sys_user where id = #{id}")
    void deleteSysUser(@Param("id") int id);
}
