package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public String addEmployee(Employee employee) {
		Employee emp = repository.save(employee);
		if (emp != null) {
			return "Employee saved successfully";
		}
		return "Failed to save employee";
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee emp = repository.save(employee);
		if (emp != null) {
			return emp;
		} else {
			return null;
		}
	}

	@Override
	public String deleteEmployee(int empId) {
		repository.deleteById(empId);
		return "Employee Deleted Successfully";
	}

	@Override
	public Employee getEmployee(int empId) throws EmployeeNotFoundException {
		return repository.findById(empId)
				.orElseThrow(() -> new EmployeeNotFoundException("No Employee Found With Given Id!!!!"));

	}

	@Override
	public List<Employee> getAllEmployee() {

		return repository.findAll();
	}

	@Override
	public List<Employee> getAllBetweenSalaries(int initialSal, int finalSal) {

		return repository.getAllBetweenSalaries(initialSal, finalSal);
	}

	@Override
	public List<Employee> getAllByDesg(String empDesg) {

		return repository.getAllByDesg(empDesg);
	}

}
