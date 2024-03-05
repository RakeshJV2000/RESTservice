package com.example.restservice;

import java.net.URI; 
import org.springframework.beans 
	.factory.annotation.Autowired; 
import org.springframework.http 
	.ResponseEntity; 
import org.springframework.web.bind 
	.annotation.GetMapping; 
import org.springframework.web.bind 
	.annotation.PostMapping; 
import org.springframework.web.bind 
	.annotation.RequestBody; 
import org.springframework.web.bind 
	.annotation.RequestMapping; 
import org.springframework.web.bind 
	.annotation.RestController; 
import org.springframework.web.servlet 
	.support.ServletUriComponentsBuilder; 

// Import the above-defined classes 
// to use the properties of those 
// classes 
import com.example.restservice.Employees; 
import com.example.restservice.EmployeeManager; 
import com.example.restservice.Employee; 

@RestController
@RequestMapping(path = "/employees") 
public class EmployeeController { 

	@Autowired
 private EmployeeManager employeeDao; 

 @GetMapping( 
		path = "/", 
		produces = "application/json") 

	public Employees getEmployees() 
	{ 

		return employeeDao 
			.getAllEmployees(); 
	} 

 @PostMapping( 
		path = "/", 
		consumes = "application/json", 
		produces = "application/json") 

	public ResponseEntity<Object> addEmployee( 
		@RequestBody Employee employee) 
	{ 
	 if (employee.getId().isEmpty()) {
         return ResponseEntity.notFound().build();
     }
		employeeDao 
			.addEmployee(employee); 

		URI location 
			= ServletUriComponentsBuilder 
				.fromCurrentRequest() 
				.path("/{id}") 
				.buildAndExpand( 
					employee.getId()) 
				.toUri(); 

		   return ResponseEntity 
			.created(location) 
			.build(); 
	} 
} 
