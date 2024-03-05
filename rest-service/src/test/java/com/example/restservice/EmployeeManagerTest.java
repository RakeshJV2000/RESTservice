package com.example.restservice;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

class EmployeeManagerTest {

	@Mock
	private EmployeeManager employeeManager;
	
	@Test
	// Ensure that email is in right format
	void addEmployeeTest() {
		Employee employee = new Employee();
		employee.setFirstName("49876");
		employee.setLastName("Sir");
		employee.setEmail("hello");
		employee.setId("92675");
		
		EmployeeManager employeemanager = new EmployeeManager();
		
		assertThrows(IllegalArgumentException.class,
				() -> {
					employeemanager.addEmployee(employee);
				});
		
		employee.setEmail("hello@gmail.com");
		this.employeeManager.addEmployee(employee);
	}
	
	@ExtendWith(MockitoExtension.class)
    @BeforeEach void setUp()
    {
		this.employeeManager = new EmployeeManager();
		Employee newEmployee = new Employee("0001", "New", "User", "newuser@gmail.com", "Sr developer");
		this.employeeManager.addEmployee(newEmployee);
    }
	

	@Test
	// Ensure added employee ID is found in ID field
	void employeeIdInList() {
		List<Employee> employees = this.employeeManager.getAllEmployees().getEmployeeList();
		for (int i=0; i<employees.size(); i++)
		{
			Employee employee = employees.get(i);
			if (employee.getId() == "0001")
			{
				return;
			}
		}
		assert(false);
	}

	@Test
	// Check whether added employee first name is found in first name field
	void employeeFirstNameInList() {
		List<Employee> employees = this.employeeManager.getAllEmployees().getEmployeeList();
		for (int i=0; i<employees.size(); i++)
		{
			Employee employee = employees.get(i);
			if (employee.getFirstName() == "New")
			{
				return;
			}
		}
		assert(false);
	}

	@Test
	// Check whether added employee last name is found in last name field
	void employeeLastNameInList() {
		List<Employee> employees = this.employeeManager.getAllEmployees().getEmployeeList();
		for (int i=0; i<employees.size(); i++)
		{
			Employee employee = employees.get(i);
			if (employee.getLastName() == "User")
			{
				return;
			}
		}
		assert(false);
	}

	@Test
	// Check whether added employee email is found in email field
	void employeeEmailInList() {
		List<Employee> employees = this.employeeManager.getAllEmployees().getEmployeeList();
		for (int i=0; i<employees.size(); i++)
		{
			Employee employee = employees.get(i);
			if (employee.getEmail() == "newuser@gmail.com")
			{
				return;
			}
		}
		assert(false);
	}

}
