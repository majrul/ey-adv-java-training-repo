package com.ey.service;

import com.ey.entity.Customer;
import com.ey.exception.CustomerServiceException;
import com.ey.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public int register(Customer customer) {
        //first check if the customer already registered
        //if customer is already registered stop and throw an exception
        //else save the customer data in db and then send an email confirmation

        Long count = customerRepository.findByEmail(customer.getEmail());
        if(count > 0)
            throw new CustomerServiceException("Customer already registered!");
        else {
            customerRepository.save(customer);
            return customer.getId();
        }
    }

    public void updateProfilePic(int customerId, String profilePic) {
        //Customer customer = customerRepository.findById(customerId).get();
        //customer.setProfilePic(profilePic);
        //customerRepository.save(customer);
        customerRepository.updateProfilePic(customerId, profilePic);
    }

    public String getProfilePic(int customerId) {
        return customerRepository.findProfilePic(customerId);
    }
}
