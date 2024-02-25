package com.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer>{
	
}
