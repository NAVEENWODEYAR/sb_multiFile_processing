package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.StudentEntity;
import com.example.demo.service.StudentService;

/**
 * @author Naveen Wodeyar
 * @date 25-Oct-2024
 * @time 1:43:17 am
 */
@RestController
@RequestMapping("/api/student")
public class StudentEntityController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public String testConnection() {
		return "CONNECTED!,";
	}
	
	@PostMapping("/add")
	public void addStudent(@RequestBody @Validated StudentEntity request) {
		try {
			studentService.save(request);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@GetMapping("/list")
	public List<StudentEntity> getList() {
		try {
			List<StudentEntity> studentList = studentService.getStudents();
			return studentList;
		} catch (Exception e) {
			throw e;
		}
	}
	
}
