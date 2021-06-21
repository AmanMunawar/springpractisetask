package com.example.springbootpractise.springbootpractisetask.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springbootpractise.springbootpractisetask.entities.Employee;
import com.example.springbootpractise.springbootpractisetask.repository.EmployeeDao;

@Service
public class EmployeeServiceImp implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return this.employeeDao.findAll();
	}

	@Override
	public Optional<Employee> getEmployee(String id) {
		 
		return this.employeeDao.findById(Integer.parseInt(id));
	}
	
	@Override
	public Employee addEmployee(Employee employee) {
		
		this.employeeDao.save(employee);
		return employee;
	}

	@Override
	public void deleteAllEmployees() {
		// TODO Auto-generated method stub
		this.employeeDao.deleteAll();
	}

	@Override
	public void deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		this.employeeDao.deleteById(id);
	}
	
}
