package com.training.component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("c1")
@Primary
public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void fetch() {
		
	}	
}
