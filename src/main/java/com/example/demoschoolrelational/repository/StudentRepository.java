package com.example.demoschoolrelational.repository;

import com.example.demoschoolrelational.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
