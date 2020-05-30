package com.snails.cache.controller;

import com.snails.cache.bean.Student;
import com.snails.cache.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/queryStudentListMap")
    public List<Student> queryStudentListMap(){
        return studentService.queryStudentListMap();
    }

    @RequestMapping("/queryStudentByNo")
    public Student queryStudentByNo(String no){
        return studentService.queryStudentByNo(no);
    }

    @RequestMapping("/add")
    public String add(Student student){
        studentService.add(student);
        return "insert success";
    }

    @RequestMapping("/update")
    public String update(Student student){
        studentService.update(student);
        return "update success";
    }

    @RequestMapping("/deleteByNo")
    public String deleteByNo(String no){
        studentService.deleteByNo(no);
        return "delete success";
    }

    @RequestMapping("/deleteAllCache")
    public void deleteAllCache(){
        studentService.deleteAllCache();
    }
}
