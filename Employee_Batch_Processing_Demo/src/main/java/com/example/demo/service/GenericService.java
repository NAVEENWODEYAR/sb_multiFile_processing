package com.example.demo.service;
/**
 * @author Naveen Wodeyar
 * @date 25-Oct-2024
 * @time 10:51:44 pm
 */
import java.util.*;
import org.springframework.stereotype.Service;


@Service
public interface GenericService<T, ID> {
    
    void save(T entity);
    
    List<T> getAll();
    
    T getById(ID id);
    
    void deleteById(ID id);
}
