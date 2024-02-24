package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.entity.Student;
import com.example.repo.StudentRepo;

@Controller
public class StudentController {

	@Autowired
	StudentRepo studentRepo;
	
	//Inserting of data
	@PostMapping("/api/students")
	public  ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<>(studentRepo.save(student),HttpStatus.CREATED);
		
		}
	//Output data of all students
	@GetMapping("/api/students")
	public ResponseEntity<List<Student>> getStudents(){
		return new ResponseEntity<>(studentRepo.findAll(),HttpStatus.OK);
	}
	//Output data of only student by id
	@GetMapping("/api/students/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable long id){
		Optional<Student> student =studentRepo.findById(id);
		if(student.isPresent()){
		return new ResponseEntity<>(student.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	//Update Data from DB
	@PutMapping("/api/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable long id,@RequestBody Student stud){
		Optional<Student> student =studentRepo.findById(id);
		if(student.isPresent()){
			student.get().setStudentName(stud.getStudentName());
			student.get().setStudentEmail(stud.getStudentEmail());
			student.get().setStudentAddress(stud.getStudentAddress());
			
		return new ResponseEntity<>(studentRepo.save(student.get()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	//Delete Data from DB
	@DeleteMapping("/api/students/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable long id){
		Optional<Student> student =studentRepo.findById(id);
		if(student.isPresent()){
			studentRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
