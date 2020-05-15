package com.snails.jdbc.dao.impl;

import com.snails.jdbc.bean.Student;
import com.snails.jdbc.dao.StudentDao;
import com.snails.jdbc.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Student student) {
        String sql = "insert into student(no,name,gender) values(?,?,?)";
        return jdbcTemplate.update(sql, student.getNo(),student.getName(),student.getGender());
    }

    @Override
    public int update(Student student) {
        String sql = "update student set name= ?,gender = ? where no = ?";
        return jdbcTemplate.update(sql,student.getName(),student.getGender(),student.getNo());
    }

    @Override
    public int deleteByNo(String no) {
        String sql = "delete from student where no = ?";
        return jdbcTemplate.update(sql,no);
    }

    @Override
    public List<Map<String, Object>> queryStudentListMap() {
        String sql = "select * from student";
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public Student queryStudentByNo(String no) {
        String sql = "select * from student where no = ?";
        return jdbcTemplate.queryForObject(sql,new StudentMapper(), no);
    }
}
