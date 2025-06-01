package com.example.enlatadosmg.controller;

import com.example.enlatadosmg.models.Pedido;
import com.example.enlatadosmg.service.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido createPedido(@RequestBody Pedido pedido, @RequestParam int cajas) {
        return pedidoService.createPedido(pedido, cajas);
    }

    @PutMapping("/{id}/complete")
    public Pedido completePedido(@PathVariable Integer id) {
        return pedidoService.completePedido(id);
    }

    @GetMapping("/pending")
    public List<Pedido> getPendingOrders() {
        return pedidoService.getPendingOrders();
    }
}