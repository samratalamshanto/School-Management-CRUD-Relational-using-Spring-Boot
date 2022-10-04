package com.example.demoschoolrelational.service;

import com.example.demoschoolrelational.entity.Student;
import com.example.demoschoolrelational.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudent(){
        List<Student> students = studentRepository.findAll(Sort.by(Sort.Direction.ASC,"roll"));

        return students;
    }

    public Student getStudentById(long id)
    {
        Student student = studentRepository.findById(id).get();

        return student;
    }

    public void addStudent(Student s1){
        studentRepository.save(s1);
    }

}
