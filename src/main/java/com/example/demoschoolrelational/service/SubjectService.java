package com.example.demoschoolrelational.service;

import com.example.demoschoolrelational.entity.Subject;
import com.example.demoschoolrelational.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    public List<Subject> getAllSubject(){
        List<Subject> subjects = subjectRepository.findAll();
        return subjects;
    }
    public void addSubject(Subject sub1)
    {
        subjectRepository.save(sub1);
    }
}
