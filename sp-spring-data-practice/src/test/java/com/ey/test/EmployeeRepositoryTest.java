package com.ey.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ey.entity.Employee;
import com.ey.repository.EmployeeRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:my-spring-config.xml")
class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Test
	void addEmployee() {
		Employee emp = new Employee();
		emp.setName("John");
		emp.setSalary(10000);
		emp.setDateOfJoining(LocalDate.now());
		
		empRepo.save(emp);
	}

}
