package com.example.demoschoolrelational.service;

import com.example.demoschoolrelational.entity.Teacher;
import com.example.demoschoolrelational.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public List<Teacher> getAllTeacher(){
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers;
    }

    public String addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
        return "Teacher Data Added.";
    }
}
