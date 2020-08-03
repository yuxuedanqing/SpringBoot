package com.snails.layui.controller;

import com.snails.layui.entity.Student;
import com.snails.layui.mapper.StudentInfoMapper;
import com.snails.layui.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentInfoController {

    @Autowired
    private StudentInfoMapper studentInfoMapper;

    @GetMapping("/getAllStudent")
    @ResponseBody
    public JsonResult getAllStudent(){
        List<Student> studentList = studentInfoMapper.getAllStudent();
        return JsonResult.ok(studentList);
    }

    @GetMapping("/findStudentById")
    @ResponseBody
    public JsonResult findStudentById(@RequestParam(value = "studentId") Integer studentId){
        Student student = studentInfoMapper.findStudentById(studentId);
        return JsonResult.ok(student);
    }

    @GetMapping("/addStudent")
    @ResponseBody
    public JsonResult addStudent() throws Exception{
        for (int i=0;i<50;i++){
            Student student = new Student();
            student.setName("张三"+i);
            student.setBirthday(LocalDate.now());
            student.setGender("男");
            studentInfoMapper.addStudent(student);
        }
        return JsonResult.ok();
    }

    @PostMapping("/updateStudent")
    @ResponseBody
    public JsonResult updateStudent(@RequestBody Student student) throws Exception{
        studentInfoMapper.updateStudent(student);
        return JsonResult.ok();
    }

    @GetMapping("/deleteStudent")
    @ResponseBody
    public JsonResult deleteStudent(@RequestParam(value = "studentId") Integer studentId) throws Exception{
        studentInfoMapper.deleteStudent(studentId);
        return JsonResult.ok();
    }

    @GetMapping(value = {"/","/index"})
    public String index(){
        return "index";
    }
}
