package com.cvt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cvt.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
	
	Optional<Customer> findByMobileNo(String mobileNo);
	
	Optional<Customer> findByEmailId(String emailId);
}
