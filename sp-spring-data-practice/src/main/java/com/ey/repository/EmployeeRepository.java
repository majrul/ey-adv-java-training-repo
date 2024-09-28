package com.ey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ey.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
