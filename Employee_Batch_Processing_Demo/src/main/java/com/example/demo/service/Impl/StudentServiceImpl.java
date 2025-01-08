package com.example.demo.service.Impl;

import java.util.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.StudentService;

/**
 * @author Naveen Wodeyar
 * @date 25-Oct-2024
 * @time 1:38:33 am
 */
@Component
public class StudentServiceImpl implements StudentService {
	
	private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public void save(StudentEntity studentEntity) {
		try {
			log.info("SAVE");
			studentRepo.save(studentEntity);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<StudentEntity> getStudents() {
		try {
			log.warn("FETCH");
			List<StudentEntity> studentList = studentRepo.findAll();
			return studentList;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public StudentEntity getStudentById(Long stId) {
		try {
			log.info("FETCH BY_ID");
			Optional<StudentEntity> student = studentRepo.findById(stId);
			return student.get();
		} catch (Exception e) {
			throw e;
		}
	}

}
