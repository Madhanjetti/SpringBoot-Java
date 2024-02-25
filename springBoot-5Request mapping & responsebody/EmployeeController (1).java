package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dao.EmployeeRepo;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeRepo empRepo;
	
	@RequestMapping("/getAllVal")
	@ResponseBody
	public String getValues() {
		
		return empRepo.findAll().toString();
	}
	
	@RequestMapping("/getInValue/100")
	@ResponseBody
	public String getIndividualValue() {
		
		return empRepo.findById(100).toString();
	}
	
	@RequestMapping("/aloneDynamic/{eid}")
	@ResponseBody
	public String getIndividualValueDynamically(@PathVariable("eid") int eid){
		
		return empRepo.findById(eid).toString();
	}
}
