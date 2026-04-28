package com.azim.crudding.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.azim.crudding.entity.Instructor;
import com.azim.crudding.entity.InstructorDetail;

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


	@Override
	public InstructorDetail findInstructorDetailById(int id) {
		return em.find(InstructorDetail.class, id);
	}


	@Override
	@Transactional
	public void deleteInstructorDetailById(int id) {
		InstructorDetail tmp = em.find(InstructorDetail.class, id);		
		tmp.getInstructor().setInstructorDetail(null);
		em.remove(tmp);
	}
}
