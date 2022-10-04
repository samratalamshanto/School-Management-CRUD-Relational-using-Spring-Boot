package com.example.demoschoolrelational.repository;

import com.example.demoschoolrelational.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
