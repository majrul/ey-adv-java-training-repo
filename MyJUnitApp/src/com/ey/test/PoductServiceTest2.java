package com.ey.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ey.product.Product;
import com.ey.product.ProductDao;
import com.ey.product.ProductService;

@ExtendWith(MockitoExtension.class)
class PoductServiceTest2 {

	@Mock
	private ProductDao productDao;
	
	@InjectMocks
	private ProductService productService;
	
	@Test
	void addProduct_ShouldBeSuccessful() {
		when(productDao.doesProductExist(anyString())).thenReturn(false);
		when(productDao.add(any())).thenReturn(5);
		
		Product product = new Product();
		product.setName("Samsung S23");
		product.setPrice(59000);
		product.setQuantity(50);
		
		int id = productService.add(product);
		assertTrue(id > 0);
	}

}
