package com.example.demoschoolrelational.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student implements Comparable<Student>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roll;
    private String studentName;

    //mapped by where we use reference to the other side of ManyToMany
    //mapped with instance's variable which is defined in other owner side
//    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudent",cascade = CascadeType.ALL,fetch = FetchType.LAZY)

    //the name of  private Set<Student> ##enrolledStudent = new HashSet<>();

//    @JsonIgnoreProperties("enrolledStudent")
//    @JsonIgnore

    @JsonManagedReference(value = "enrolledStudent")
    private Set<Subject> enrolledSubject = new HashSet<>();

    public void enrollSubject(Subject sub1) {
        enrolledSubject.add(sub1);
    }


    @Override
    public int compareTo(Student thatStudent) {
        long rollCompare = ((Student) thatStudent).getRoll();
        return (int)(this.roll-rollCompare);
    }

    public long getRoll() {
        return roll;
    }

    public void setRoll(long roll) {
        this.roll = roll;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Set<Subject> getEnrolledSubject() {
        return enrolledSubject;
    }

    public void setEnrolledSubject(Set<Subject> enrolledSubject) {
        this.enrolledSubject = enrolledSubject;
    }
}
