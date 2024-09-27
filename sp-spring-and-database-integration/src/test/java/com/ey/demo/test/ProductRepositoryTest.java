package com.ey.demo.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ey.demo.Product;
import com.ey.demo.ProductRepository;

class ProductRepositoryTest {

	private static ConfigurableApplicationContext ctx;
	private static ProductRepository prodRepo;
	
	@BeforeAll
	static void init() {
		ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		prodRepo = ctx.getBean(ProductRepository.class);
	}
	
	@AfterAll
	static void cleanup() {
		ctx.close();
	}
	
	@Test
	void addProduct() {
		Product product = new Product();
		product.setName("iPhone 16 Pro");
		product.setPrice(129000);
		product.setQuantity(99);
		prodRepo.save(product);
	}

	@Test
	void updateProduct() {
		Product p = prodRepo.findById(1).get();
		p.setPrice(p.getPrice() - p.getPrice() * 0.10);
		prodRepo.save(p);
	}
	
	@Test
	void deleteProduct() {
		prodRepo.deleteById(1);
	}
	
	@Test
	void fetchProducts() {
		//List<Product> list = prodRepo.findAll();
		//List<Product> list = prodRepo.findByPriceGreaterThanEqual(98100);
		List<Product> list = prodRepo.findByNameLike("iPhone");
		assertTrue(list.size() > 0);
	}
}
