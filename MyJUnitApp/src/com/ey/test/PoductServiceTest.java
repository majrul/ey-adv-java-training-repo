package com.ey.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ey.product.Product;
import com.ey.product.ProductDao;
import com.ey.product.ProductService;

class PoductServiceTest {

	@Test
	void addProduct_ShouldBeSuccessful() {
		ProductDao productDao = new ProductDao();
		ProductService productService = new ProductService(productDao);
		
		Product product = new Product();
		product.setName("Samsung S23");
		product.setPrice(59000);
		product.setQuantity(50);
		
		int id = productService.add(product);
		assertTrue(id > 0);
	}

}
