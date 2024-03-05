package com.example.restservice;

import java.util.List;
import java.util.regex.*;

import org.springframework 
	.stereotype 
	.Repository; 

// Importing the employees class to 
// use the defined properties 
// in this class 
import com.example.restservice.Employees; 

@Repository

public class EmployeeManager { 

	private static Employees list 
		= new Employees(); 

	static
	{ 

		list.getEmployeeList().add( 
			new Employee( 
				"73618", 
				"Prem", 
				"Tiwari", 
				"chapradreams@gmail.com",
				"Sr coder")); 

		list.getEmployeeList().add( 
			new Employee( 
				"21334", "Vikash", 
				"Kumar", 
				"abc@gmail.com",
				"Jr coder")); 

		list.getEmployeeList().add( 
			new Employee( 
				"63956", "Ritesh", 
				"Ojha", 
				"asdjf@gmail.com",
				"Sr coder")); 

		  
	} 

	public Employees getAllEmployees() 
	{ 

		return list; 
	} 
	public void addEmployee(Employee employee) 
	{
		String atSymbolRegex = "^[^@]+@[^@]+$";
		String email = employee.getEmail();
		
        Pattern pattern = Pattern.compile(atSymbolRegex);
        
        Matcher matcher = pattern.matcher(email);
		if(!(matcher.matches())) {
			throw new IllegalArgumentException("Email id not in correct format");
		}
		
		list.getEmployeeList() 
			.add(employee); 
		  
	} 
} 

