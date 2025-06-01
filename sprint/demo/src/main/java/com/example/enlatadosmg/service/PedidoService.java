package com.example.enlatadosmg.service;

import com.example.enlatadosmg.models.*;
import com.example.enlatadosmg.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RepartidorRepository repartidorRepository;

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private AlmacenService almacenService;

    @Autowired
    private CajaPorPedidoRepository cajaPorPedidoRepository;

    public Pedido createPedido(Pedido pedido, int cantidadCajas) {
        // Set basic info
        pedido.setFechaHoraInicio(new Date());
        pedido.setEstado(Pedido.EstadoPedido.Pendiente);

        // Assign client
        Cliente cliente = clienteRepository.findById(pedido.getCliente().getCui()).orElse(null);
        pedido.setCliente(cliente);

        // Assign available delivery person
        Repartidor repartidor = repartidorRepository.findFirstByDisponibleTrue();
        if (repartidor != null) {
            repartidor.setDisponible(false);
            repartidorRepository.save(repartidor);
            pedido.setRepartidor(repartidor);
        }

        // Assign available vehicle
        Vehiculo vehiculo = vehiculoRepository.findFirstByDisponibleTrue();
        if (vehiculo != null) {
            vehiculo.setDisponible(false);
            vehiculoRepository.save(vehiculo);
            pedido.setVehiculo(vehiculo);
        }

        // Save the order first
        Pedido savedPedido = pedidoRepository.save(pedido);

        // Add boxes from warehouse (LIFO)
        for (int i = 0; i < cantidadCajas; i++) {
            Almacen caja = almacenService.pop();
            if (caja != null) {
                CajaPorPedido cajaPedido = new CajaPorPedido();
                cajaPedido.setPedido(savedPedido);
                cajaPedido.setAlmacen(caja);
                cajaPorPedidoRepository.save(cajaPedido);
            }
        }

        return savedPedido;
    }

    public Pedido completePedido(Integer pedidoId) {
        Pedido pedido = pedidoRepository.findById(pedidoId).orElse(null);
        if (pedido != null) {
            pedido.setEstado(Pedido.EstadoPedido.Completado);

            // Free up resources
            if (pedido.getRepartidor() != null) {
                Repartidor repartidor = pedido.getRepartidor();
                repartidor.setDisponible(true);
                repartidorRepository.save(repartidor);
            }

            if (pedido.getVehiculo() != null) {
                Vehiculo vehiculo = pedido.getVehiculo();
                vehiculo.setDisponible(true);
                vehiculoRepository.save(vehiculo);
            }

            return pedidoRepository.save(pedido);
        }
        return null;
    }

    public List<Pedido> getPendingOrders() {
        return pedidoRepository.findByEstadoOrderByFechaHoraInicioAsc(Pedido.EstadoPedido.Pendiente);
    }
}
