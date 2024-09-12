package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EmployeeData;

/**
 * @author Naveen Wodeyar
 * @date 11-Sept-2024
 * @time 9:47:46 pm
 */
@Repository
public interface EmployeeDataRepo extends JpaRepository<EmployeeData, Integer>{

}
