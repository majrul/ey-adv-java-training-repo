package com.ey;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.ey.entity.Employee;
import com.ey.repository.EmployeeRepository;

@SpringBootTest
@ActiveProfiles("test")
class EmployeeTest {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	void add() {
		Employee emp = new Employee();
		emp.setName("Samantha");
		emp.setSalary(10000);
		emp.setDateOfJoining(LocalDate.now());
		
		employeeRepository.save(emp);
		
		assertTrue(emp.getEmpno() > 0);
	}

}
