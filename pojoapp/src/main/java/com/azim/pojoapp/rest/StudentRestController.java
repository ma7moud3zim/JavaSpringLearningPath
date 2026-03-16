package com.azim.pojoapp.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azim.pojoapp.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> Studs;
	
	
	@PostConstruct
	public void loadData() {
		Studs = new ArrayList<>();
		
		Studs.add(new Student("Ahmed" , "Khaled"));
		Studs.add(new Student("Sayed" , "Hamed"));
		Studs.add(new Student("Iron" , "Tawfik"));
	}
	
	// define an End-point of students
	@GetMapping("/students")
	public List<Student> getStudents(){		
		return Studs;
	}
	
	// Define an End-point for retrieving single student by ID 
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		
		if(studentId >= Studs.size() || studentId < 0) {
			throw new StudentNotFoundException("Studend id not found - " + studentId);
		}
		
		return Studs.get(studentId);
	}
	

	
}
