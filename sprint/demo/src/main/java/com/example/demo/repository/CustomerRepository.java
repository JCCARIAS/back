package com.example.demo.repository;

import com.example.demo.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends CrudRepository<Cliente, Long> {
    List<Cliente> findAllById(Long id);
}



