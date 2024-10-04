package com.training.entity;

import java.util.List;

public class Product {

	private int id;
	private String name;
	private double price;
	
	private String serviceAddress;
	
	private List<Rating> ratings;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
	public String getServiceAddress() {
		return serviceAddress;
	}
	public void setServiceAddress(String serviceAddress) {
		this.serviceAddress = serviceAddress;
	}
}
