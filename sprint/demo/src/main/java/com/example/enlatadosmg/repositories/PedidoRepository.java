package com.example.enlatadosmg.repositories;

import com.example.enlatadosmg.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByEstadoOrderByFechaHoraInicioAsc(Pedido.EstadoPedido estado);
}