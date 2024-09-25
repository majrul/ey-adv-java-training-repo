package com.ey.demo;

import java.util.List;

public interface ProductDao {

	void add(Product product);

	void update(Product product);

	Product fetchOne(int id);

	List<Product> fetchAll();

	void delete(int id);

}