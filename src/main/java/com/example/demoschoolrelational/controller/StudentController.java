package com.example.demoschoolrelational.controller;

import com.example.demoschoolrelational.entity.Student;
import com.example.demoschoolrelational.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudent();
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") long id)
    {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public void addStudent(@RequestBody  Student student)
    {
        studentService.addStudent(student);
    }


}
