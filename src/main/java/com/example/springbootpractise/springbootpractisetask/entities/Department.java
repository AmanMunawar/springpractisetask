package com.example.springbootpractise.springbootpractisetask.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nameOfDepartment;
	
	@OneToMany(cascade = CascadeType.ALL,
			mappedBy = "department",
			fetch = FetchType.LAZY)
	private List<Employee> employees;
	
	public Department() {
		
	}
	
	public Department(int id, String nameOfDepartment) {
		
		this.id = id;
		this.nameOfDepartment = nameOfDepartment;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getNameOfDepartment() {
		return this.nameOfDepartment;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public void setDepartmentName(String name) {
		this.nameOfDepartment = name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", nameOfDepartment=" + nameOfDepartment + ", employees=" + employees + "]";
	}
	
	
	
}
