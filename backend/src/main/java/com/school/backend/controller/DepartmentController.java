package com.school.backend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.school.backend.dto.DepartmentDto;
import com.school.backend.service.DepartmentService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
       DepartmentDto newDepartment =  departmentService.createDepartment(departmentDto);
       return new ResponseEntity<>(newDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId) {
       DepartmentDto departmentDto = departmentService.getDepartmentById(departmentId);
       return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        List<DepartmentDto> departmentDtoList = departmentService.getAllDepartments();
        return new ResponseEntity<>(departmentDtoList, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId,
                                                          @RequestBody DepartmentDto departmentDto) {
       DepartmentDto updatedDepartment = departmentService.updateDepartment(departmentId, departmentDto);
       return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return new ResponseEntity<>("Delete Department Successfully", HttpStatus.OK);
    }
}