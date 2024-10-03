package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.training.entity.Product;
import com.training.service.ProductCompositeService;

@RestController
public class ProductCompositeController {

	@Autowired
	private ProductCompositeService productCompositeService;
	
	@GetMapping("/product-info/{productId}")
	public Product getProductInfo(@PathVariable int productId) {
		return productCompositeService.getProduct(productId);
	}

}
