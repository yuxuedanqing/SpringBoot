package com.snails.cache.service.impl;

import com.snails.cache.bean.Student;
import com.snails.cache.mapper.StudentMapper;
import com.snails.cache.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@CacheConfig(cacheNames = "studentCache")
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @CachePut(cacheNames = {"student"}, key = "#student.no")
    @Override
    public void add(Student student) {
        System.out.println("写入缓存");
        studentMapper.add(student);
    }

    @CacheEvict(cacheNames = {"student"}, key = "#student.no")
    @Override
    public void update(Student student) {
        System.out.println("清除缓存");
        studentMapper.update(student);
    }

    @CacheEvict(cacheNames = {"student"}, key = "#no")
    @Override
    public void deleteByNo(String no) {
        System.out.println("清除缓存");
        studentMapper.deleteByNo(no);
    }

    @Cacheable(cacheNames = {"student"})
    @Override
    public List<Student> queryStudentListMap() {
        System.out.println("缓存不存在，执行方法");
        return studentMapper.queryStudentListMap();
    }

    @Cacheable(key = "#no")
    @Override
    public Student queryStudentByNo(String no) {
        System.out.println("缓存不存在，执行方法");
        return studentMapper.queryStudentByNo(no);
    }

    @CacheEvict(value = "student", allEntries = true)
    @Override
    public void deleteAllCache() {

    }

    @CacheEvict(value = "student", beforeInvocation = true)
    @Override
    public void deleteAllCacheBefore() {

    }

}
