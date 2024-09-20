package com.ey.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ey.entity.Product;
import com.ey.excepion.ProductExceptionMapper.Error;

public class MyRestClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/MyRestApp/api/product/all");
		
		System.out.println("------------ code to get all products -------------------");
		String responseStr = target
								.request()
								.accept(MediaType.APPLICATION_JSON)
								.get()
								.readEntity(String.class);
		System.out.println(responseStr);
		
		List<Product> listOfProducts = target
										.request()
										.get()
										.readEntity(new GenericType<List<Product>>() { });
		
		for(Product product : listOfProducts) {
			System.out.println("------------------");
			System.out.println(product.getId());
			System.out.println(product.getName());
			System.out.println(product.getPrice());
			System.out.println(product.getQuantity());
		}
	
		System.out.println("------------ code to get product by id -------------------");
		target = client.target("http://localhost:8080/MyRestApp/api/product/{id}");
		responseStr = target
						.resolveTemplate("id", 1)
						.request()
						.get()
						.readEntity(String.class);
		System.out.println(responseStr);
		
		target = client.target("http://localhost:8080/MyRestApp/api/product/{id}");
		Product product = target
						.resolveTemplate("id", 1)
						.request()
						.get()
						.readEntity(Product.class);
		
		System.out.println("------------------");
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		System.out.println(product.getQuantity());
		
		System.out.println("------------------");
		/*Response responseObj = target
								.resolveTemplate("id", 1)
								.request()
								.get()
								.readEntity(Response.class);
		if(responseObj.getStatus() == 400) {
			Error error = responseObj.readEntity(Error.class);
			System.out.println(error.getErrorCode());
			System.out.println(error.getErrorMessage());
			System.out.println(error.getTimestamp());
		}
		else {
			product = responseObj.readEntity(Product.class);
			System.out.println(product.getId());
			System.out.println(product.getName());
			System.out.println(product.getPrice());
			System.out.println(product.getQuantity());
		}*/
		
		System.out.println("------------ code to POST a product -------------------");
		Product p = new Product();
		p.setName("Samsung S24");
		p.setPrice(79000);
		p.setQuantity(99);

		target = client.target("http://localhost:8080/MyRestApp/api/product/add");
		responseStr = target
						.request()
						.post(Entity.entity(p, MediaType.APPLICATION_JSON), String.class);
		System.out.println(responseStr);
	}

}
