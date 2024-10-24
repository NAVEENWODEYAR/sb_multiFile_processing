package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.StudentService;

/**
 * @author Naveen Wodeyar
 * @date 25-Oct-2024
 * @time 1:38:33 am
 */
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public void save(StudentEntity studentEntity) {
		try {
			studentRepo.save(studentEntity);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<StudentEntity> getStudents() {
		try {
			List<StudentEntity> studentList = studentRepo.findAll();
			return studentList;
		} catch (Exception e) {
			throw e;
		}
	}

}
