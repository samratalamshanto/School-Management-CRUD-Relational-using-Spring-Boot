package com.example.demoschoolrelational.controller;

import com.example.demoschoolrelational.entity.Subject;
import com.example.demoschoolrelational.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @GetMapping
    public List<Subject> getAllSubject(){
        return subjectService.getAllSubject();
    }

    @PostMapping
    public void addSubject(@RequestBody  Subject sub1){
        subjectService.addSubject(sub1);
    }
}
