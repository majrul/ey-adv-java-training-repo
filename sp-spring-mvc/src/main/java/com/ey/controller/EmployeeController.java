package com.ey.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ey.entity.Employee;
import com.ey.repository.EmployeeRepository;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	/*@RequestMapping("/add-emp")
	public String add(@RequestParam String name, 
					  @RequestParam String dateOfJoining, 
					  @RequestParam double salary, 
					  Model model) {
		Employee emp = new Employee();
		emp.setName(name);
		emp.setDateOfJoining(LocalDate.parse(dateOfJoining));
		emp.setSalary(salary);
		
		employeeRepository.save(emp);
		
		model.addAttribute("message", "Employee added successfully!");
		return "addEmp.jsp";
	}*/
	
	//Spring can automatically copy form data in an object for us
	@RequestMapping("/add-emp")
	public String add(Employee emp, Model model) {
		employeeRepository.save(emp);	
		model.addAttribute("message", "Employee added successfully!");
		return "addEmp.jsp";
	}
	
	@RequestMapping("/get-emp")
	public String get(@RequestParam int empno, Map model) {
		Optional<Employee> emp = employeeRepository.findById(empno);
		if(emp.isPresent()) {
			model.put("emp", emp.get());
			return "viewEmp.jsp";
		}
		else {
			model.put("message", "No employee with the given empno found!");
			return "getEmp.jsp";
		}
	}

	@RequestMapping("/get-all-emps")
	public String get(Map model) {
		List<Employee> list = employeeRepository.findAll();
		model.put("listOfEmps", list);
		return "viewAllEmps.jsp";
	}
}
