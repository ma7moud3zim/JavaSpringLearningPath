package com.azim.crudding.dao;

import com.azim.crudding.entity.Instructor;

public interface AppDAO {

	void save(Instructor theInstructor);
	
	Instructor findInstructorById(int id);
	void deleteInstructorById(int id);
}
