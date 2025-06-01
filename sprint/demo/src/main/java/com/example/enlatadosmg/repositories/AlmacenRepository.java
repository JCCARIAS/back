package com.example.enlatadosmg.repositories;

import com.example.enlatadosmg.models.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlmacenRepository extends JpaRepository<Almacen, Integer> {
    Almacen findTopByOrderByCorrelativoDesc();
}