package com.ey.demo;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("daoImpl3")
public class ProductDaoImpl3 implements ProductDao {

	@Autowired
	private DataSource dataSource;
	
	@Override
	public int add(Product product) {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		String sql = "insert into product(name, price, quantity) values(?,?,?)";
		jt.update(sql, product.getName(), product.getPrice(), product.getQuantity());
		//TODO: fetch the generated pk and return it
		return 999;
	}

	@Override
	public void update(Product product) {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		String sql = "update product set name = ?, price = ?, quantity = ? where id = ?";
		jt.update(sql, product.getName(), product.getPrice(), product.getQuantity(), product.getId());
	}

	@Override
	public Product fetchOne(int id) {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		String sql = "select * from product where id = ?";
		Product product = jt.query(sql, BeanPropertyRowMapper.newInstance(Product.class)).get(0);
		return product;
	}

	@Override
	public List<Product> fetchAll() {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		String sql = "select * from product";
		List<Product> list = jt.query(sql, BeanPropertyRowMapper.newInstance(Product.class));
		return list;
	}
	
	@Override
	public void delete(int id) {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		String sql = "delete from product where id = ?";
		jt.update(sql, id);
	}
}
