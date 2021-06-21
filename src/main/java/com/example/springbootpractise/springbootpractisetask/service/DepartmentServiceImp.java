package com.example.springbootpractise.springbootpractisetask.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootpractise.springbootpractisetask.entities.Department;
import com.example.springbootpractise.springbootpractisetask.repository.DepartmentDao;

@Service
public class DepartmentServiceImp implements DepartmentService {

	@Autowired 
	private DepartmentDao departmentDao;
	
	public Department addDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentDao.save(department);
		return department;
	}

	public Department getDepartment(int id) {
		// TODO Auto-generated method stub
		return departmentDao.getById(id);
	}

	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return departmentDao.findAll();
	}

	public void deleteDepartmentById(int id) {
		this.departmentDao.deleteById(id);
	}
	
	public void deleteAllDepartments() {
		this.departmentDao.deleteAll();
	}
}
