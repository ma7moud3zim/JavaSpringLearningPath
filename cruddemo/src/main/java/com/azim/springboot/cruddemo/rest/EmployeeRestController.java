package com.azim.springboot.cruddemo.rest;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.azim.springboot.cruddemo.entity.Employee;
import com.azim.springboot.cruddemo.service.EmployeeService;

import tools.jackson.databind.json.JsonMapper;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	private EmployeeService empService;
	private JsonMapper jsonMapper;
	
	
	public EmployeeRestController(EmployeeService theEmpService, JsonMapper theJsonMapper) {
		empService= theEmpService;
		jsonMapper =theJsonMapper;
	}
	
	// expose "/employees" and return a list of employees
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return empService.findAll();
	}
	
	// add mapping for GET /employees/{empId}
	@GetMapping("/employees/{empId}")
	public Employee getEmployee(@PathVariable int empId) {
		Employee theEmp = empService.findById(empId);
		
		if(theEmp == null) {
			throw new RuntimeException("Employee id not found - " + empId);
		}
		return theEmp;
	}
	
	// add mapping for POST /employees - add new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmp) {
		theEmp.setId(0);
		Employee dbEmployee = empService.save(theEmp);
		return dbEmployee;
	}
	
	 // add mapping for PUT /employees - update existing employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmp) {
		Employee dbEmp = empService.save(theEmp);
		return dbEmp;
	}
	
	
	// add mapping for PATCH
	@PatchMapping("/employees/{employeeId}")
	public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String,Object> patchPayload) {
		
		Employee tempEmp = empService.findById(employeeId);
		
		if(tempEmp == null) {
			throw new RuntimeException("Employee id not found - "+employeeId);
		}
		if(patchPayload.containsKey("id")) {
			throw new RuntimeException("Employee id not allowed in request body - "+employeeId);
		}
		
		Employee patchedEmp = jsonMapper.updateValue(tempEmp, patchPayload);
		Employee dbEmp = empService.save(patchedEmp);
		
		return dbEmp;
	}
	
	
	// add mapping for DELETE /employees/{employeeId} = delete employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee tmpEmp = empService.findById(employeeId);
		if(tmpEmp == null) {
			throw new RuntimeException("Employee id not found - "+ employeeId);
		}
		empService.deleteById(employeeId);
		
		return "Deleted Employee Id -" + employeeId;	
	}
	
	
}
