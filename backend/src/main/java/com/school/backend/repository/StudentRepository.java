package com.school.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.backend.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
