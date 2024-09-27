package com.ey.demo.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ey.demo.Product;
import com.ey.demo.ProductDao;

class ProductTest {

	private static ConfigurableApplicationContext ctx;
	private static ProductDao dao;
	
	@BeforeAll
	static void init() {
		ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		dao = (ProductDao) ctx.getBean("daoImpl4");		
	}
	
	@AfterAll
	static void cleanup() {
		ctx.close();
	}
	
	@Test
	void addProduct() {
		Product product = new Product();
		product.setName("iPhone 15 Pro");
		product.setPrice(109000);
		product.setQuantity(99);
		int id = dao.add(product);

		assertTrue(id > 0);
	}

	@Test
	void updateProduct() {
		Product p = dao.fetchOne(1);
		p.setPrice(p.getPrice() - p.getPrice() * 0.10);
		dao.update(p);
		//TODO: add the required assert statement
	}
	
	@Test
	void deleteProduct() {
		dao.delete(1);
		//TODO: add the required assert statement
	}
	
	@Test
	//@RepeatedTest(5)
	void fetchProducts() {
		long ms1 = System.currentTimeMillis();
		List<Product> list = dao.fetchAll();
		long ms2 = System.currentTimeMillis();
		System.out.println("approx overall time taken " + (ms2 - ms1) + " ms");
		
		assertTrue(list.size() > 0);
	}
}
