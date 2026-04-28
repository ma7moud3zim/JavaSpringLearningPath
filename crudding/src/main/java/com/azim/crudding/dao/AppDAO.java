package com.azim.crudding.dao;

import com.azim.crudding.entity.Instructor;
import com.azim.crudding.entity.InstructorDetail;

public interface AppDAO {

	void save(Instructor theInstructor);
	
	Instructor findInstructorById(int id);
	void deleteInstructorById(int id);
	InstructorDetail findInstructorDetailById(int id);
	void deleteInstructorDetailById(int id);
}
