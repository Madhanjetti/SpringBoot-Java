package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dao.EmployeeRepo;
import com.example.model.Employee;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepo empRepo;

    @GetMapping("/getAllVal")
    public Iterable<Employee> getValues() {

        return empRepo.findAll();
    }

    // inserted by using params
    @PostMapping("/insert")
    public Employee addValues(Employee emp) {
        empRepo.save(emp);
        return emp;
    }

    // inserted by using body-raw values
    @PostMapping("/insertRaw")
    public Employee addRawValues(@RequestMapping Employee emp) {

        empRepo.save(emp);
        return emp;
    }

    @DeleteMapping("/delete/{eid}")
    public String deleteValue(@PathVariable("eid") int eid) {
        Employee emp = empRepo.getOne(eid);
        empRepo.delete(emp);
        return "deleted";
    }

    // update all Values
    @PutMapping("/update")
    public Employee updateValue(@RequestBody Employee emp) {
        empRepo.save(emp);
        return emp;
    
}
