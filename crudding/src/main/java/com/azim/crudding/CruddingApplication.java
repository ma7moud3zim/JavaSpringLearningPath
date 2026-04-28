package com.azim.crudding;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.azim.crudding.dao.AppDAO;
import com.azim.crudding.entity.Instructor;
import com.azim.crudding.entity.InstructorDetail;

@SpringBootApplication
public class CruddingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddingApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commanLinerunner(AppDAO appDAO){
		
		return runner->{
			// createInstructor(appDAO);
			// findInsrtuctor(appDAO);
			deleteInstructor(appDAO);
		};
		
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 2;
		appDAO.deleteInstructorById(id);
		System.out.println("Instructor with id " + id+" was deleted successfully");
	}

	private void findInsrtuctor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);
		Instructor retInstructor = appDAO.findInstructorById(id);
		System.out.println("The res: " + retInstructor);
		System.out.println("The associated details: " + retInstructor.getInstructorDetail());
		
		
	}

	private void createInstructor(AppDAO appDAO) {
		// create the instructor
		/*
		Instructor tmpInst = new Instructor("Mahmoud","Abdelazim","mahmoudaytta@gmail.com");
		InstructorDetail tmpInstDetail = new InstructorDetail(
				"https://bit.ly/cv3zim",
				"Reading");
		*/
		Instructor tmpInst = new Instructor("Ahmed","Ibraheem","AhmedIbra@gmail.com");
		InstructorDetail tmpInstDetail = new InstructorDetail(
				"https://bit.ly/cv3zim",
				"PES");
		tmpInst.setInstructorDetail(tmpInstDetail);
		
		// This will also save the details object because of cascade
		
		System.out.println("Saving instructor: " + tmpInst);
		appDAO.save(tmpInst);
		System.out.println("Done");

	}

}
