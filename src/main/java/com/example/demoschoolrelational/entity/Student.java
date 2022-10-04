package com.example.demoschoolrelational.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data //lombok
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roll;
    private String studentName;

    @ManyToMany
    private Set<Subject> enrolledSubject = new HashSet<>();
}
