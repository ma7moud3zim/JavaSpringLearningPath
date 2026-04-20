package com.azim.springboot.cruddemo.service;
import com.azim.springboot.cruddemo.entity.Employee;
import java.util.List;

public interface EmployeeService {
	
	List<Employee> findAll();
	Employee findById(int theId);
	Employee save(Employee theEmps);
	void deleteById(int theId);
}
