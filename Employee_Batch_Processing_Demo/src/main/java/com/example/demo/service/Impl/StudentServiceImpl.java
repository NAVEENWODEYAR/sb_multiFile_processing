package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	@Autowired
	private StudentRepo studentRepo;

	// Add @Transactional to the save method to ensure the operation happens within a transaction
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void save(StudentEntity studentEntity) {
		try {
			log.info("SAVE");
			studentRepo.save(studentEntity);
		} catch (Exception e) {
			// If any exception occurs, the transaction will be rolled back by default for unchecked exceptions
			log.error("Error saving student: " + e.getMessage());
			throw e;
		}
	}

	// Add @Transactional to the method to ensure the database read operation is wrapped in a transaction
	@Override
	@Transactional(readOnly = true)
	public List<StudentEntity> getStudents() {
		try {
			log.warn("FETCH");
			List<StudentEntity> studentList = studentRepo.findAll();
			return studentList;
		} catch (Exception e) {
			log.error("Error fetching students: " + e.getMessage());
			throw e;
		}
	}

	// Add @Transactional to the method to ensure the database read operation is wrapped in a transaction
	@Override
	@Transactional(readOnly = true)
	public StudentEntity getStudentById(Integer stId) {
		try {
			log.info("FETCH BY_ID");
			Optional<StudentEntity> student = studentRepo.findById(stId);
			return student.orElseThrow(() -> new RuntimeException("Student not found with id: " + stId));
		} catch (Exception e) {
			log.error("Error fetching student by ID: " + e.getMessage());
			throw e;
		}
	}
}
