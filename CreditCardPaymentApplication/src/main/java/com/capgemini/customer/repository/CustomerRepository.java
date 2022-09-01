package com.capgemini.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.customer.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
