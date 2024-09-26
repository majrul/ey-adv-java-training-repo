package com.ey.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ey.demo.Product;
import com.ey.demo.ProductDao;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		
		ProductDao dao = (ProductDao) ctx.getBean("daoImp1");
		
		//entities are not instantiated using spring
		/*Product product = new Product();
		product.setName("iPhone 16 Pro");
		product.setPrice(129000);
		product.setQuantity(99);
		dao.add(product);*/
		
		List<Product> list = dao.fetchAll();
		list.forEach(System.out::println);
		
		System.out.println("Done!");
	}
}
