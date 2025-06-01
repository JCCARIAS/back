package com.example.enlatadosmg.repositories;

import com.example.enlatadosmg.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
}