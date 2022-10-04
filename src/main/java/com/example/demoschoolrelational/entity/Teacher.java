package com.example.demoschoolrelational.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String teacherName;
    @ManyToMany
    private Set <Student> enrolledStudent = new HashSet<>();

    @ManyToMany
    private Set<Subject> takenSubject = new HashSet<>();


}
