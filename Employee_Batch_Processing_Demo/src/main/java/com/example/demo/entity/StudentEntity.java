package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
/**
 * @author Naveen Wodeyar
 * @date 25-Oct-2024
 * @time 1:31:32 am
 */
@Entity
@Table(name = "student_table")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "City can't be empty")
	@Size(min = 4,max = 50,message = "Should be between 2-50 characters")
    private String name;
    
    @NotNull(message = "City can't be empty")
	@Size(min = 4,max = 50,message = "Should be between 2-50 characters")
    private int age;
    
    @NotNull(message = "City can't be empty")
	@Size(min = 4,max = 50,message = "Should be between 2-50 characters")
    private String email;

    public StudentEntity() {
    }

    // Parameterized constructor
    public StudentEntity(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // hashCode and equals
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        StudentEntity student = (StudentEntity) obj;
        return id != null && id.equals(student.id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
