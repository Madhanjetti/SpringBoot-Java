package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.EmployeeRepo;
import com.example.model.Employee;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeRepo empRepo;
	
	@RequestMapping("/") //localhost:8082
	public String homePage() {
		
		return "home.jsp";
	}
	
	@RequestMapping("/add")
	public String addValues(Employee emp) {
		empRepo.save(emp); //insert into employee values(100, 'vinoth', 234324.456);
		return "home.jsp";
	}
	
	
	@RequestMapping("/selectRow")
	public ModelAndView getValue(@RequestParam("eid") int empId) {
		Employee emp = empRepo.findById(empId).orElse(new Employee());
		ModelAndView mv = new ModelAndView("showValue.jsp");
		mv.addObject("empObj", emp);
		
		System.out.println("findByEname : " +empRepo.findByEname("Vinoth"));
		
		/*List<Employee> list = empRepo.findByEname("Vinoth");
		for(Employee elist : list) {
			System.out.println(elist.getEid()+"  "+elist.getEname()+"  "+elist.getSalary());
		}*/
		
		System.out.println("findBySalary : " +empRepo.findBySalary(123234.45));
		
		/*List<Employee> listSalary = empRepo.findBySalary(123234.45);
		for(Employee listSalaryObject : listSalary) {
			System.out.println(listSalaryObject.getEid()+"  "+listSalaryObject.getEname()+"  "+listSalaryObject.getSalary());
		}*/
		
		System.out.println("findByEidGreaterThan : " +empRepo.findByEidGreaterThan(100));
		
		System.out.println("findByEidLessThan : " +empRepo.findByEidLessThan(103));
		
		return mv;
	}
}
