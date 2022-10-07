package com.example.demoschoolrelational.controller;

import com.example.demoschoolrelational.entity.Student;
import com.example.demoschoolrelational.entity.Subject;
import com.example.demoschoolrelational.service.StudentService;
import com.example.demoschoolrelational.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Subject> getAllSubject(){
        return subjectService.getAllSubject();
    }

    @GetMapping("/allenrolledstudent/{subId}")
    public List<Student> getAllEnrolledStudent(@PathVariable("subId") long subId){
        return subjectService.getAllEnrolledStudent(subId);
    }

    @PostMapping
    public void addSubject(@RequestBody  Subject sub1){
        subjectService.addSubject(sub1);
    }



    @PutMapping("/{subjectId}/student/{studentId}")
    public Subject enrolledStudentToSubject(
            @PathVariable("subjectId") long subjectId,
            @PathVariable("studentId") long studentId
    )
    {
        return subjectService.enrolledStudentToSubject(subjectId,studentId);

    }
}
