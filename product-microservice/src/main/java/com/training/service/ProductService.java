package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.training.entity.Product;
import com.training.exception.ProductException;
import com.training.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@CachePut(value = "product.cache", key = "#product.id")
	public Product add(Product product) {
		productRepository.save(product);
		return product;
	}
	
	@Cacheable(value = "product.cache", key = "#id")
	public Product get(int id) {
		return productRepository
				.findById(id)
				.orElseThrow(() -> new ProductException("No product found with id " + id));
	}
	
	@Cacheable(value = "products.cache", key = "#ids")
	public List<Product> fetch(List<Integer> ids) {
		return productRepository.findAllById(ids);
	}
}
