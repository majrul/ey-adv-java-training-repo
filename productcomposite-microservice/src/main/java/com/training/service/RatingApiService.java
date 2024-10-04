package com.training.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.training.entity.Rating;

@FeignClient(name = "productratings-microservice")
public interface RatingApiService {

	@GetMapping("/rating/{id}")
	public List<Rating> get(@PathVariable int id);
}
