package com.ey.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

//public interface ProductRepository extends CrudRepository<Product, Integer> {
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	public List<Product> findByPriceGreaterThanEqual(double price);
	
	@Query("select p from Product p where p.name like %?1%")
	public List<Product> findByNameLike(String name);
	
	/*Product save(Product product);

	Product findById(int id);

	List<Product> findAll();

	void deleteById(int id);*/

}

//select p from Product p join p.orders o where o.date = ?1