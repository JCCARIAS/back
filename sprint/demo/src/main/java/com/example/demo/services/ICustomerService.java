package com.example.demo.services;


import com.example.demo.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  ICustomerService{
    List<Customer> getAll();

    List<Customer> get(Long id);
    Customer findAllById(Long id);

    Customer getById(Long id);

    void remove(Long id);
    void save(Customer customer);
}
