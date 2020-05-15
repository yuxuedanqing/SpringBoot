package com.snails.jdbc.service;

import com.snails.jdbc.bean.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    /**
     * 添加学生信息
     * @param student student
     * @return  int
     */
    int add(Student student);

    /**
     * 修改学生信息
     * @param student student
     * @return int
     */
    int update(Student student);

    /**
     * 根据学号删除学生信息
     * @param no 学号
     * @return int
     */
    int deleteByNo(String no);

    /**
     * 查找所有学生列表
     * @return <code>List<Map<String,Object>></></code>
     */
    List<Map<String,Object>> queryStudentListMap();

    /**
     * 根据学号查找学生信息
     * @param no 学号
     * @return student
     */
    Student queryStudentByNo(String no);
}
