package com.example.demoschoolrelational.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String subjectName;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(  //new table
            name = "student_enrolled_sub",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    @JsonBackReference(value = "enrolledSubject")

//    @JsonIgnoreProperties("enrolledSubject")
    private Set<Student> enrolledStudent = new HashSet<>();  //set used for unique students list



    public void enrollStudent(Student student) {
        enrolledStudent.add(student);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Set<Student> getEnrolledStudent() {
        return enrolledStudent;
    }

    public void setEnrolledStudent(Set<Student> enrolledStudent) {
        this.enrolledStudent = enrolledStudent;
    }
}
