package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("Select e from Employee e where e.empSal between ?1 and ?2")
	public List<Employee> getAllBetweenSalaries(int initialSal, int finalSal);
	
//	List<Employee> findByEmpSalBetween(int startSal, int endSal);
	
	
	
	@Query("Select e from Employee e where e.empDesg = ?1")
	public List<Employee> getAllByDesg(String empDesg);
}
