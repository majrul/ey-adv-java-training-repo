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
	} //merge can be used instead of persist method

	@Override
	public void update(Product product) {
		entityManager.merge(product); //merge will generate update query
	}

	@Override
	public Product fetchOne(int id) {
		return entityManager.find(Product.class, id); //find will generate select query with where pk = ?
	}

	@Override
	public List<Product> fetchAll() {
		return entityManager.createQuery("select p from Product p", Product.class).getResultList(); //HQL/JPQL
	}
	
	@Override
	public void delete(int id) {
		Product p = entityManager.find(Product.class, id);
		entityManager.remove(p); //remove will generate delete query
	}
}
