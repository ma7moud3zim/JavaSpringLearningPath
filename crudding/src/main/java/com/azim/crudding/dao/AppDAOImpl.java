package com.azim.crudding.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.azim.crudding.entity.Instructor;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@Repository
public class AppDAOImpl implements AppDAO{

	private EntityManager em;
	
	@Autowired
	public AppDAOImpl(EntityManager theEm) {
		this.em = theEm;
	}
	
	
	@Transactional
	public void save(Instructor theInstructor) {
		em.persist(theInstructor);
	}

	@Override
	public Instructor findInstructorById(int id) {
		return em.find(Instructor.class, id);
	}


	@Override
	@Transactional
	public void deleteInstructorById(int id) {
		Instructor cur = em.find(Instructor.class, id);
		em.remove(cur);
	}
}
