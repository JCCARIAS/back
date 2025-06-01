package com.example.enlatadosmg.repositories;

import com.example.enlatadosmg.models.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, String> {
    List<Vehiculo> findByDisponibleTrueOrderByPlacaAsc();
    Vehiculo findFirstByDisponibleTrue();
}