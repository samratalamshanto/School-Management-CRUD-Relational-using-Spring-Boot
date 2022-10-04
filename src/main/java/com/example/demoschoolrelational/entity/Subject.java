package com.example.demoschoolrelational.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String subjectName;

    @ManyToMany
    private Set<Student> enrolledStudent = new HashSet<>();

}
