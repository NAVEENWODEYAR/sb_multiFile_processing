package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.StudentEntity;

/**
 * @author Naveen Wodeyar
 * @date 25-Oct-2024
 * @time 1:34:09 am
 */

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Integer> {

}
