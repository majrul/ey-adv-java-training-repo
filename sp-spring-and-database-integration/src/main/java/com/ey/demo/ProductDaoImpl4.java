package com.ey.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("daoImpl4")
@Transactional
public class ProductDaoImpl4 implements ProductDao {

	//@Autowired doesn't works in case of injecting EntityManager object
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public int add(Product product) {
		entityManager.persist(product); //persist will generate insert query
		return product.getId();
	}

	@Override
	public void update(Product product) {

	}

	@Override
	public Product fetchOne(int id) {
		return null;
	}

	@Override
	public List<Product> fetchAll() {
		return null;
	}
	
	@Override
	public void delete(int id) {

	}
}
