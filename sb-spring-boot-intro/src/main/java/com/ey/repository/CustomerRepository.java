package com.ey.repository;

import com.ey.entity.Customer;
import com.ey.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("select count(c) from Customer c where c.email = ?1")
	public Long findByEmail(String email);

	@Query("select c.profilePic from Customer c where c.id = ?1")
	public String findProfilePic(int id);

	@Modifying
	@Query("update Customer c set c.profilePic = ?2 where c.id = ?1")
	public int updateProfilePic(int id, String profilePic);
}
