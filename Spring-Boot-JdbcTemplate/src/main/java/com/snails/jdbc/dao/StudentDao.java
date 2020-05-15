package com.snails.jdbc.dao;

import com.snails.jdbc.bean.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    /**
     * 新增学生
     * @param student  student
     * @return  int
     */
    int add(Student student);

    /**
     * 更新学生信息
     * @param student  student
     * @return  int
     */
    int update(Student student);

    /**
     * 删除学生信息
     * @param no 学号
     * @return  int
     */
    int deleteByNo(String no);

    /**
     * 查询所有学生信息
     * @return <code>List<Map<String,Object>></code>
     */
    List<Map<String,Object>> queryStudentListMap();

    /**
     * 根据学号查找学生信息
     * @param no 学号
     * @return student
     */
    Student queryStudentByNo(String no);
}
