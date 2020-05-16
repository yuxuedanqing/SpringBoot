package com.snails.aop.dao;

import com.snails.aop.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysLogDao {

    @Insert("insert into sys_log(id,user_name,operation,time,method,params,ip,create_time) " +
            "values(#{id},#{userName},#{operation},#{time},#{method},#{params},#{ip},#{createTime})")
    void saveSysLog(SysLog sysLog);
}
