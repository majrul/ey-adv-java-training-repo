package com.ey.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ey.product.Product;
import com.ey.product.ProductDao;
import com.ey.product.ProductService;

@ExtendWith(MockitoExtension.class)
class PoductServiceTest3 {

	@Spy
	private ProductDao productDao = new ProductDao();
	
	@InjectMocks
	private ProductService productService;
	
	@Test
	void addProduct_ShouldBeSuccessful() {
		when(productDao.doesProductExist(anyString())).thenReturn(false);
		
		Product product = new Product();
		product.setName("Samsung S23");
		product.setPrice(59000);
		product.setQuantity(50);
		
		int id = productService.add(product);
		assertTrue(id > 0);
	}

}
