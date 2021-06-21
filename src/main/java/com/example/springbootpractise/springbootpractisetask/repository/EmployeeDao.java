package com.example.springbootpractise.springbootpractisetask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootpractise.springbootpractisetask.entities.Employee;


public interface EmployeeDao extends JpaRepository<Employee, Integer>{

}
