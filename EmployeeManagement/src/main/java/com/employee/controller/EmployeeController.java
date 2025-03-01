package com.employee.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private Map<Long, Employee> myEmp = new HashMap<>();
	
	@GetMapping
	public List<Employee> getAll(){
		return new ArrayList<>(myEmp.values());
	}
	
	@PostMapping
	public boolean createEmployee(@RequestBody Employee employee) {
		myEmp.put(employee.getId(), employee);
		return true;
	}
	
	@GetMapping("id/{myId}")
	public Employee getEmployeeById(@PathVariable Long myId) {
		return myEmp.get(myId);
	}
	
	@PutMapping("id/{myId}")
	public Employee updateEmployeeById(@PathVariable Long myId,@RequestBody Employee employee) {
		return myEmp.put(myId,employee);
	}
	
	@DeleteMapping("id/{myId}")
	public Employee deleteEmployeeById(@PathVariable Long myId) {
		return myEmp.remove(myId);
	}
}
