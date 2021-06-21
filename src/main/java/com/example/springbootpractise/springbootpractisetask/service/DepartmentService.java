package com.example.springbootpractise.springbootpractisetask.service;

import java.util.List;

import com.example.springbootpractise.springbootpractisetask.entities.Department;

public interface DepartmentService {
	
	public Department addDepartment(Department department);
	public Department getDepartment(int id);
	public List<Department> getAllDepartments();
	public void deleteDepartmentById(int id);
	public void deleteAllDepartments();

}
