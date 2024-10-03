package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.dto.Status;
import com.training.entity.Product;
import com.training.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/product/add")
	public Status add(@RequestBody Product product) {
		productService.add(product);
		
		return new Status(true, "Product added!");
	}
	
	@GetMapping("/product/{id}")
	public Product get(@PathVariable int id) {
		return productService.get(id);
	}
	
}
