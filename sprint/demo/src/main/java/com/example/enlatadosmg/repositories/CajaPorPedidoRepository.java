package com.example.enlatadosmg.repositories;


import com.example.enlatadosmg.models.CajaPorPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CajaPorPedidoRepository extends JpaRepository<CajaPorPedido, Integer> {
    List<CajaPorPedido> findByPedido(Pedido pedido);
}