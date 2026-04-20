package com.azim.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.azim.springboot.cruddemo.dao.EmployeeDAO;
import com.azim.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeDAO empDAO;
	
	@Autowired 
	public EmployeeServiceImpl(EmployeeDAO theEmpDAO) {
		empDAO = theEmpDAO;
	}
	
	
	
	@Override
	public List<Employee> findAll() {
		return empDAO.findAll();
	}



	@Transactional
	@Override
	public Employee findById(int theId) {
		return empDAO.findById(theId);
	}



	@Override
	public Employee save(Employee theEmp) {
		return empDAO.save(theEmp);
	}



	@Transactional
	@Override
	public void deleteById(int theId) {
		empDAO.deleteById(theId);
	}

}
