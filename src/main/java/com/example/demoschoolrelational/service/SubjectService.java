package com.example.demoschoolrelational.service;

import com.example.demoschoolrelational.entity.Student;
import com.example.demoschoolrelational.entity.Subject;
import com.example.demoschoolrelational.repository.StudentRepository;
import com.example.demoschoolrelational.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    StudentRepository studentRepository;

    public List<Subject> getAllSubject() {
        List<Subject> subjects = subjectRepository.findAll();
        return subjects;
    }

    public List<Student> getAllEnrolledStudent(long id) {
        List<Student> studentList = new ArrayList<Student>();
        Subject sub1 = subjectRepository.findById(id).get();


        for (Student s1: sub1.getEnrolledStudent()) {
            studentList.add(s1);
        }

        Collections.sort(studentList);
        return studentList;

    }

    public void addSubject(Subject sub1) {
        subjectRepository.save(sub1);
    }

    public Subject enrolledStudentToSubject(long subId, long studId) {

        Subject subject = subjectRepository.findById(subId).get();
        Student student = studentRepository.findById(studId).get();
        System.out.println(student);
        System.out.println(subject);

        subject.enrollStudent(student); //add student in the subject ###ManyToMany

        student.enrollSubject(subject);
        studentRepository.save(student);

        return subjectRepository.save(subject);
    }

}
