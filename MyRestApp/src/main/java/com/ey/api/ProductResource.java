package com.ey.api;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.ey.dao.ProductDao;
import com.ey.entity.Product;
import com.ey.entity.ProductDetails;
import com.ey.entity.Status;

@Path("/product")
public class ProductResource {

	@GET
	@Path("/{id}")
	public Product getOne(@PathParam("id") int id) {
		ProductDao dao = new ProductDao();
		Product product = dao.fetchOne(id);
		return product;
	}
	
	@GET
	@Path("/all")
	public List<Product> getAll() {
		ProductDao dao = new ProductDao();
		List<Product> list = dao.fetchAll();
		return list;
	}
	
	@POST
	@Path("/add")
	public Status add(Product product) {
		ProductDao dao = new ProductDao();
		dao.add(product);
		
		Status status = new Status();
		status.setStatus(true);
		status.setMessageIfAny("Product added successfully!");
		return status;
	}
	
	@PUT
	@Path("/update")
	public Status update(Product product) {
		ProductDao dao = new ProductDao();
		dao.update(product);
		
		Status status = new Status();
		status.setStatus(true);
		status.setMessageIfAny("Product updated successfully!");
		return status;
	}
	
	@PATCH
	@Path("/update/patch")
	public Status update(ProductDetails productDetails) {
		ProductDao dao = new ProductDao();
		Product product = dao.fetchOne(productDetails.getId());
		
		//figure out how to remove the below if conditions
		if(productDetails.getPropertyName().equals("name"))
			product.setName(productDetails.getPropertyValue());
		else if(productDetails.getPropertyName().equals("price"))
			product.setPrice(Double.parseDouble(productDetails.getPropertyValue()));
		else if(productDetails.getPropertyName().equals("quantity"))
			product.setQuantity(Integer.parseInt(productDetails.getPropertyValue()));
		
		dao.update(product);
		
		Status status = new Status();
		status.setStatus(true);
		status.setMessageIfAny("Product updated successfully!");
		return status;
	}

	@DELETE
	@Path("/{id}")
	public Status delete(@PathParam("id") int id) {
		ProductDao dao = new ProductDao();
		dao.delete(id);
		
		Status status = new Status();
		status.setStatus(true);
		status.setMessageIfAny("Product deleted successfully!");
		return status;
	}
}
