package com.snails.cache.mapper;

import com.snails.cache.bean.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface StudentMapper {

    /**
     * 添加学生信息
     * @param student student
     */
    @Insert("insert into student(no,name,gender) values(#{no},#{name},#{gender})")
    void add(Student student);

    /**
     * 修改学生信息
     * @param student student
     */
    @Update("update student set name=#{name},gender=#{gender} where no=#{no}")
    void update(Student student);

    /**
     * 根据学号删除学生信息
     * @param no 学号
     */
    @Delete("delete from student where no=#{no}")
    void deleteByNo(String no);

    /**
     * 查找所有学生列表
     * @return <code>List<Map<String,Object>></></code>
     */
    @Select("select * from student")
    List<Student> queryStudentListMap();

    /**
     * 根据学号查找学生信息
     * @param no 学号
     * @return student
     */
    @Select("select * from student where no=#{no}")
    Student queryStudentByNo(String no);
}
