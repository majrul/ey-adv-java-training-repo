package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.entity.Product;
import com.training.entity.Rating;

@Service
public class ProductCompositeService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${product-service.url}")
	private String productServiceUrl;
	
	@Value("${rating-service.url}")
	private String ratingServiceUrl;
	
	public Product getProduct(int productId) {
		String productUrl = productServiceUrl + "/product/{id}";
		String ratingUrl = ratingServiceUrl + "/rating/{id}";
		
		Product productAggregate = restTemplate.getForObject(productUrl, Product.class, productId);
		
		List<Rating> ratings = restTemplate.getForObject(ratingUrl, List.class, productId);
		
		productAggregate.setRatings(ratings);
		
		return productAggregate;
	}
}
