package com.example.demoschoolrelational.repository;

import com.example.demoschoolrelational.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
