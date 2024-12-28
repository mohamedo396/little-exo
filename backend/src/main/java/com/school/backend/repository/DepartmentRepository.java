package com.school.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.backend.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
