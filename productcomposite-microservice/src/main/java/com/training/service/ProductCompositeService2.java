package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.entity.Product;
import com.training.entity.Rating;

@Service
public class ProductCompositeService2 {

	@Autowired
	private ProductApiService productApiService;

	@Autowired
	private RatingApiService ratingApiService;
	
	public Product getProduct(int productId) {
		Product productAggregate = productApiService.get(productId);
		List<Rating> ratings = ratingApiService.get(productId);
		productAggregate.setRatings(ratings);
		
		return productAggregate;
	}
}
