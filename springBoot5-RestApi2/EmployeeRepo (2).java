package com.example.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer>{
	
}


/*
insert into EMPLOYEE values(100, 123234.45, 'Vinoth');
insert into EMPLOYEE values(101, 9898978.45, 'Raji');
insert into EMPLOYEE values(102, 4765765.676, 'Siva');
SELECT * FROM EMPLOYEE; 
 
 */