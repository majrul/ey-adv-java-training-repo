package com.ey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ey.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("select e from Employee e where e.empno = ?1 or e.name like %?2% or e.salary >= ?3 or year(e.dateOfJoining) = ?4")
	public List<Employee> findBy(Integer empno, String name, Double salary, Integer year);
}
