package com.azim.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.azim.cruddemo.dao.StudentDAO;
import com.azim.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner CommandLineRunner(StudentDAO studentDAO) {
		return runner->{
			deleteAllStudents(studentDAO);		
		};
	
	}
	
	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting All students");
		int dl = studentDAO.deleteAll();
		System.out.println("Deleted rows: " + dl);
	}


	private void deleteStudent(StudentDAO studentDAO) {
		int studId = 3;
		System.out.println("deleting num "+ studId);
		studentDAO.delete(studId);
	}


	private void updateStudent(StudentDAO studentDAO) {
		int studId=1;
		Student stud = studentDAO.findById(studId);
		stud.setFirstName("Scooby");
		studentDAO.update(stud);
		System.out.println("Updated student: "+stud);	
	}


	private void QueryForFindByLastName(StudentDAO studentDAO) {
		List<Student> stud = studentDAO.findByLastName("Khaled");
		for ( Student tmp: stud) {
			System.out.println(tmp);
		}
	}


	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();
		
		for ( Student tmp: theStudents) {
			System.out.println(tmp);
		}
	}


	private void readStudent(StudentDAO studentDAO) {
		// create a student
		System.out.println("Create a new student");
		Student tempStudent = new Student("Daffy" , "Duck", "heeh@gmail.com");
		// save it in DB
		studentDAO.save(tempStudent);
		// display id
		int theId = tempStudent.getId();
		System.out.println("Saved student with gen id: "+ theId);
		// retrieve and display it 
		Student myStudent = studentDAO.findById(theId);
		
		System.out.println("Found student: "+myStudent);
		
	}


	private void createMultiStudent(StudentDAO studentDAO) {
		System.out.println("Create a new 3 students");
		Student tempStudent = new Student("Mohamed" , "Khaled", "Mokh@gmail.com");
		Student tempStudent2 = new Student("Tawfik" , "Sayed", "tefa@gmail.com");
		Student tempStudent3 = new Student("Ibraheem" , "Saeed", "hema@gmail.com");
		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}
	
	private void createStudent(StudentDAO studentDAO) {
		// create student object
		System.out.println("Create a new student");
		Student tempStudent = new Student("Ahmed" , "Sayed", "Ahmed@gmail.com");
		// save student
		System.out.println("Saving the Student in the Database");
		studentDAO.save(tempStudent);
		
		// display id of the saved student
		System.out.println("Saved Student. Generated id: "+ tempStudent.getId());
	}
	
	
}
