package com.snails.layui.mapper;

import com.snails.layui.entity.Student;

import java.util.List;

public interface StudentInfoMapper {

    /**
     * 获取所有学生
     * @return studentList
     */
    List<Student> getAllStudent();

    /**
     * 根据学生 ID 查找
     * @param id id
     * @return student
     */
    Student findStudentById(Integer id);

    /**
     * 添加学生
     * @param student student
     * @return student add count
     * @throws Exception exception
     */
    Integer addStudent(Student student) throws Exception;

    /**
     * 更新学生信息
     * @param student student
     * @return student update count
     * @throws Exception exception
     */
    Integer updateStudent(Student student) throws Exception;

    /**
     * 删除学生
     * @param id student id
     * @return delete student count
     * @throws Exception exception
     */
    Integer deleteStudent(Integer id) throws Exception;

}
