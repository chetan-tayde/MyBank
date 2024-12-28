package com.cvt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.cvt.dto.CustomerDto;
import com.cvt.entity.Customer;
import com.cvt.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordCofiguration;
	
	public Customer customerService(CustomerDto customerDto) {
		if(customerRepository.findByEmailId(customerDto.getEmailId()).isPresent() ||
		  customerRepository.findByMobileNo(customerDto.getMobileNo()).isPresent()) {
			throw new RuntimeException("Email or Mobile Number already registered.");
		}
		
		Customer customer = new Customer();
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setMobileNo(customerDto.getMobileNo());
		customer.setEmailId(customerDto.getEmailId());
		customer.setUserName(customerDto.getUserName());
		customer.setPassword(passwordCofiguration.encode(customerDto.getPassword()));
		
		return customerRepository.save(customer);
	}
}
