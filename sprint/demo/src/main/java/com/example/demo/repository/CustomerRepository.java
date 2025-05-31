package com.example.demo.repository;

import com.example.demo.entities.Customer;
import com.example.demo.services.ICustomerService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    ICustomerService findAllById(Long id);
}



