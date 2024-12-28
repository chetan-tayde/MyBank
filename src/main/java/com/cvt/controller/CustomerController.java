package com.cvt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cvt.dto.CustomerDto;
import com.cvt.entity.Customer;
import com.cvt.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerCustomer(@RequestBody CustomerDto customerDto, BindingResult result){
		 if (result.hasErrors()) {
	            return ResponseEntity.badRequest().body(result.getAllErrors());
	        }
		 
		 if(!customerDto.getPassword().equals(customerDto.getConfirmPassword())) {
			 return ResponseEntity.badRequest().body("Password and Confirm Password do not match");
		 }
		Customer savedCustomer =  customerService.customerService(customerDto);
		return ResponseEntity.ok(savedCustomer);
	}

}
