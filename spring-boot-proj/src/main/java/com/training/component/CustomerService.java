package com.training.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class CustomerService {

	@Autowired // IoC / DI / Wiring
	private EmailService emailService;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	//@Qualifier("c4")
	private CustomerDao customerDao;

	public void placeOrder() {
		//some business logic here
		orderDao.save();
		//EmailService emailService = new EmailService();
		emailService.sendEmail();
	}
}
