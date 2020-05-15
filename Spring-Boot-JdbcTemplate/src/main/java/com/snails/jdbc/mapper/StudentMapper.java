package com.snails.jdbc.mapper;

import com.snails.jdbc.bean.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Student(
                resultSet.getString("no"),
                resultSet.getString("name"),
                resultSet.getString("gender"));
    }
}
