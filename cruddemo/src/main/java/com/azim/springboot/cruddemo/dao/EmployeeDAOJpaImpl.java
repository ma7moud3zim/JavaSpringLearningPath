package com.azim.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.azim.springboot.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
	private EntityManager em;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEM) {
		em = theEM;
	}
	@Override
	public List<Employee> findAll() {
		// create query 
		TypedQuery<Employee> theQ = em.createQuery("from Employee",Employee.class);
		
		// execute and get result
		List<Employee> emp = theQ.getResultList();
		
		// return the results
		return emp;
	}
	
	
	@Override
	public Employee findById(int theId) {
		Employee theEmp = em.find(Employee.class, theId);
		return theEmp;
	}
    @Transactional
	@Override
	public Employee save(Employee theEmps) {
		Employee dbEmp = em.merge(theEmps);
		return dbEmp;
	}
    
    @Transactional  
	@Override
	public void deleteById(int theId) {
		Employee theEmp = em.find(Employee.class,theId);
		em.remove(theEmp);
	}
	
}
