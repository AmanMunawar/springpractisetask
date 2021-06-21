package com.example.springbootpractise.springbootpractisetask.controller;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootpractise.springbootpractisetask.entities.Department;
import com.example.springbootpractise.springbootpractisetask.entities.Employee;
import com.example.springbootpractise.springbootpractisetask.service.DepartmentService;
import com.example.springbootpractise.springbootpractisetask.service.EmployeeService;



@RestController
public class ManagementController {

	@Autowired
	private EmployeeService employeeServiceImp;
	@Autowired 
	private DepartmentService departmentService;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
	
		return this.employeeServiceImp.getAllEmployees();
	}
	
	@GetMapping("/employees/{employeeId}")
	public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable String employeeId) {
		
		return Optional
	            .ofNullable( this.employeeServiceImp.getEmployee(employeeId))
	            .map( employee -> ResponseEntity.ok().body(employee) )          //200 OK
	            .orElseGet( () -> ResponseEntity.notFound().build() );  //404 Not found
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		return this.employeeServiceImp.addEmployee(employee);
	}
	
	@DeleteMapping("/employees")
	public ResponseEntity<HttpStatus> deleteAllEmployees(){
		try {
			this.employeeServiceImp.deleteAllEmployees();
			return new ResponseEntity<HttpStatus> (HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/employees/{emp_id}")
	public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable String emp_id){
		try {
			this.employeeServiceImp.deleteEmployeeById(Integer.parseInt(emp_id));
			return new ResponseEntity<HttpStatus> (HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/departments")
	public Department addDepartment(@RequestBody Department department) {
		
		logger.info("Add department", department.toString());
		return this.departmentService.addDepartment(department);
	}
	
	@GetMapping("/departments")
	public List<Department> getDepartments(){
		return this.departmentService.getAllDepartments();
	}
	
	@GetMapping("/departments/{dep_id}")
	public Department getDepartmentByID(@PathVariable String dep_id) {
		return this.departmentService.getDepartment(Integer.parseInt(dep_id));
	}
	
	@DeleteMapping("/departments/{dep_id}")
	public ResponseEntity<HttpStatus> deleteDepartmentByID(@PathVariable String dep_id){
		
		try {
			
			logger.info("Deleting department with id", dep_id);
			this.departmentService.deleteDepartmentById(Integer.parseInt(dep_id));
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/departments")
	public ResponseEntity<HttpStatus> deleteAllDepartments(){
		try {
			
			logger.info("deleting all departments");
			this.departmentService.deleteAllDepartments();
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
	}
}
