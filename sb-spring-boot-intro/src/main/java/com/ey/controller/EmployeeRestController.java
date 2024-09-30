package com.ey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ey.entity.Employee;
import com.ey.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employee/*")
@CrossOrigin()
public class EmployeeRestController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping("/add")
	public String add(@RequestBody Employee emp) {
		employeeRepository.save(emp);
		return "Employee with empno " + emp.getEmpno() + " added successfully!";
	}
	
	@GetMapping("/all")
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}
	
	@GetMapping("/{empno}")
	public Employee get(@PathVariable int empno) {
		return employeeRepository.findById(empno).get();
	}
	
	@GetMapping("/search")
	public List<Employee> search(@RequestParam(required = false) Integer empno, @RequestParam(required = false) String name, @RequestParam(required = false) Double salary, @RequestParam(required = false) Integer year) {
		return employeeRepository.findBy(empno, name, salary, year);
	}
	
	@PutMapping("/update")
	public String update(@RequestBody Employee emp) {
		employeeRepository.save(emp);
		return "Employee updated successfully!";
	}

	@DeleteMapping("/{empno}")
	public String delete(@PathVariable int empno) {
		employeeRepository.deleteById(empno);
		return "Employee deleted successfully!";
	}
}
