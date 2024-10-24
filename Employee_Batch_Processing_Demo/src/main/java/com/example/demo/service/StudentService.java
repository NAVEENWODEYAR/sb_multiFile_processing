package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentEntity;

/**
 * @author Naveen Wodeyar
 * @date 25-Oct-2024
 * @time 1:37:02 am
 */
@Service
public interface StudentService {
	
	void save(StudentEntity studentEntity);
	List<StudentEntity> getStudents();

}
