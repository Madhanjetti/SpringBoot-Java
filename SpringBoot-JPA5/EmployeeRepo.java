package com.example.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer>{
	
	List<Employee> findByEname(String name);
	
	List<Employee> findBySalary(double salary);
	
	List<Employee> findByEidGreaterThan(int eid);
	
	List<Employee> findByEidLessThan(int eid);

}
