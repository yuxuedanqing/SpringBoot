package com.snails.jdbc.controller;

import com.snails.jdbc.bean.Student;
import com.snails.jdbc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/queryStudent")
    public Student queryStudentByNo(String no){
        return studentService.queryStudentByNo(no);
    }

    @GetMapping(value = "/queryAllStudent")
    public List<Map<String,Object>> queryAllStudent(){
        return studentService.queryStudentListMap();
    }

    @PostMapping(value = "/addStudent")
    public int saveStudent(String no,String name,String gender){
        Student student = new Student(no, name, gender);
        return studentService.add(student);
    }

    @DeleteMapping(value = "/deleteStudent")
    public int deleteStudentByNo(String no){
        return studentService.deleteByNo(no);
    }

    @PutMapping(value = "/updateStudent")
    public int updateStudent(String no,String name,String gender){
        Student student = new Student(no, name, gender);
        return studentService.update(student);
    }
}
