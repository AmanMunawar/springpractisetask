package com.example.springbootpractise.springbootpractisetask.service;

import java.util.List;
import java.util.Optional;

import com.example.springbootpractise.springbootpractisetask.entities.Employee;


public interface EmployeeService {

	public List<Employee> getAllEmployees();
	
	public Optional<Employee> getEmployee(String id);
	
	public Employee addEmployee(Employee employee);
	
	public void deleteAllEmployees();
	
	public void deleteEmployeeById(int id);
}
