package com.example.demo.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.demo.entity.EmployeeData;

/**
 * @author Naveen Wodeyar
 * @date 11-Sept-2024
 * @time 11:59:40 pm
 */
@Component
public class EmployeeProcessor implements ItemProcessor<EmployeeData, EmployeeData>{

	@Override
	public EmployeeData process(EmployeeData item) throws Exception {

		if(item.getCountry().equalsIgnoreCase("India")) {
			
		}
		
		return item;
	}
	

}
