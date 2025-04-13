package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.JDBCException;
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
	@Transactional(rollbackFor = JDBCException.class)
	public void save(StudentEntity studentEntity) {
		long startTime = System.nanoTime(); // Start time for performance measurement
		long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); // Start memory

		try {
			log.info("SAVE");
			studentRepo.save(studentEntity);
		} catch (Exception e) {
			log.error("Error saving student: " + e.getMessage());
			throw e;
		}

		long endTime = System.nanoTime(); // End time for performance measurement
		long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); // End memory

		long timeTaken = endTime - startTime; // Time in nanoseconds
		long memoryUsed = endMemory - startMemory; // Memory in bytes

		log.info("Time taken for save: " + timeTaken + " ns");
		log.info("Memory used for save: " + memoryUsed + " bytes");
	}

	// Add @Transactional to the method to ensure the database read operation is wrapped in a transaction
	@Override
	@Transactional(readOnly = true)
	public List<StudentEntity> getStudents() {
		long startTime = System.nanoTime();
		long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		try {
			log.warn("FETCH");
			List<StudentEntity> studentList = studentRepo.findAll();
			return studentList;
		} catch (Exception e) {
			log.error("Error fetching students: " + e.getMessage());
			throw e;
		} finally {
			long endTime = System.nanoTime();
			long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

			long timeTaken = endTime - startTime;
			long memoryUsed = endMemory - startMemory;

			log.info("Time taken for fetching students: " + timeTaken + " ns");
			log.info("Memory used for fetching students: " + memoryUsed + " bytes");
		}
	}

	// Add @Transactional to the method to ensure the database read operation is wrapped in a transaction
	@Override
	@Transactional(readOnly = true)
	public StudentEntity getStudentById(Integer stId) {
		long startTime = System.nanoTime();
		long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		try {
			log.info("FETCH BY_ID");
			Optional<StudentEntity> student = studentRepo.findById(stId);
			return student.orElseThrow(() -> new RuntimeException("Student not found with id: " + stId));
		} catch (Exception e) {
			log.error("Error fetching student by ID: " + e.getMessage());
			throw e;
		} finally {
			long endTime = System.nanoTime();
			long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

			long timeTaken = endTime - startTime;
			long memoryUsed = endMemory - startMemory;

			log.info("Time taken for fetching student by ID: " + timeTaken + " ns");
			log.info("Memory used for fetching student by ID: " + memoryUsed + " bytes");
		}
	}
}
