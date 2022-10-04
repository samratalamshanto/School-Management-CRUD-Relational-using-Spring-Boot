package com.example.demoschoolrelational.controller;

import com.example.demoschoolrelational.entity.Teacher;
import com.example.demoschoolrelational.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @GetMapping
    public List<Teacher> getAllTeacher(){
        return teacherService.getAllTeacher();
    }

    @PostMapping
    public String addTeacher(@RequestBody  Teacher teacher)
    {
        return teacherService.addTeacher(teacher);
    }
}
