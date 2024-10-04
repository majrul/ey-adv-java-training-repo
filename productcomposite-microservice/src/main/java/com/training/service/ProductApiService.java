package com.training.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.training.entity.Product;

@FeignClient(name = "product-microservice")
public interface ProductApiService {

	@GetMapping("/product/{id}")
	public Product get(@PathVariable int id);
}
