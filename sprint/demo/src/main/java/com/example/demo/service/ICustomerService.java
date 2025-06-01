package com.example.demo.service;


import com.example.demo.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  ICustomerService{
    List<Cliente> getAll();




    Cliente getById(Long id);

    void remove(Long id);
    void save(Cliente customer);
}
