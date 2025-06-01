package com.example.enlatadosmg.repositories;

import com.example.enlatadosmg.models.Repartidor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RepartidorRepository extends JpaRepository<Repartidor, String> {
    List<Repartidor> findByDisponibleTrueOrderByCuiAsc();
    Repartidor findFirstByDisponibleTrue();
}