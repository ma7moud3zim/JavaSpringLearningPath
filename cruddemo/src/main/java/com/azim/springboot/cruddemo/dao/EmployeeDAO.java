package com.azim.springboot.cruddemo.dao;
import java.util.List;

import com.azim.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	List<Employee> findAll();
	
	Employee findById(int theId);
	Employee save(Employee theEmps);
	void deleteById(int theId);
}
