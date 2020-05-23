package com.snails.cache.service;

import com.snails.cache.bean.Student;

import java.util.List;

public interface StudentService {

    /**
     * 添加学生信息
     * @param student student
     */
    void add(Student student);

    /**
     * 修改学生信息
     * @param student student
     */
    void update(Student student);

    /**
     * 根据学号删除学生信息
     * @param no 学号
     */
    void deleteByNo(String no);

    /**
     * 查找所有学生列表
     * @return <code>List<Map<String,Object>></></code>
     */
    List<Student> queryStudentListMap();

    /**
     * 根据学号查找学生信息
     * @param no 学号
     * @return student
     */
    Student queryStudentByNo(String no);

    /**
     * 清除所有缓存
     */
    void deleteAllCache();

    /**
     * 方法调用前清除所有缓存
     */
    void deleteAllCacheBefore();
}
