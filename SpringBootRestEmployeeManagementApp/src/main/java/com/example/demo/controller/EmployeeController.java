package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/emps")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/save")
	public String saveEmployee(@RequestBody Employee employee) {
		return service.addEmployee(employee);
	}
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}
	
	@DeleteMapping("/deleteById/{empId}")
	public String deleteEmployee(@PathVariable int empId) {
		return service.deleteEmployee(empId);
	}
	
	@GetMapping("/getById/{empId}")
	public Employee getEmployee(@PathVariable int empId) throws EmployeeNotFoundException {
		return service.getEmployee(empId);
	}
	
	@GetMapping("/getAll")
	public List<Employee> getAllEmployee() {
		return service.getAllEmployee();
	}
	
	@GetMapping("/getAllBetween/{sal1}/{sal2}")
	public List<Employee> getAllBetweenSalaries(@PathVariable("sal1") int initialSal, @PathVariable("sal2") int finalSal) {
		return service.getAllBetweenSalaries(initialSal, finalSal);
	}
	
	@GetMapping("/getAllByDesg/{desg}")
	public List<Employee> getAllByDesg(@PathVariable String desg) {
		return service.getAllByDesg(desg);
	}
}
