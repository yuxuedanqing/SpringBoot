package com.snails.jdbc.service.impl;

import com.snails.jdbc.bean.Student;
import com.snails.jdbc.dao.StudentDao;
import com.snails.jdbc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public int add(Student student) {
        return studentDao.add(student);
    }

    @Override
    public int update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public int deleteByNo(String no) {
        return studentDao.deleteByNo(no);
    }

    @Override
    public List<Map<String, Object>> queryStudentListMap() {
        return studentDao.queryStudentListMap();
    }

    @Override
    public Student queryStudentByNo(String no) {
        return studentDao.queryStudentByNo(no);
    }
}
