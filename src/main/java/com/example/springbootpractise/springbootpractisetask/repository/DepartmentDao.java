package com.example.springbootpractise.springbootpractisetask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootpractise.springbootpractisetask.entities.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer> {

}
