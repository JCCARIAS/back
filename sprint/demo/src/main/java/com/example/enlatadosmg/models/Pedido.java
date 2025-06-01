package com.example.enlatadosmg.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numeroPedido;

    private String departamentoOrigen;
    private String departamentoDestino;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraInicio;

    @ManyToOne
    @JoinColumn(name = "cliente_cui")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "repartidor_cui")
    private Repartidor repartidor;

    @ManyToOne
    @JoinColumn(name = "vehiculo_placa")
    private Vehiculo vehiculo;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estado = EstadoPedido.Pendiente;

    @ManyToOne
    @JoinColumn(name = "next_pedido")
    private Pedido next;

    @ManyToOne
    @JoinColumn(name = "prev_pedido")
    private Pedido prev;

    public enum EstadoPedido {
        Pendiente, Completado
    }

    // Getters and Setters
    public Integer getNumeroPedido() { return numeroPedido; }
    public void setNumeroPedido(Integer numeroPedido) { this.numeroPedido = numeroPedido; }
    public String getDepartamentoOrigen() { return departamentoOrigen; }
    public void setDepartamentoOrigen(String departamentoOrigen) { this.departamentoOrigen = departamentoOrigen; }
    public String getDepartamentoDestino() { return departamentoDestino; }
    public void setDepartamentoDestino(String departamentoDestino) { this.departamentoDestino = departamentoDestino; }
    public Date getFechaHoraInicio() { return fechaHoraInicio; }
    public void setFechaHoraInicio(Date fechaHoraInicio) { this.fechaHoraInicio = fechaHoraInicio; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Repartidor getRepartidor() { return repartidor; }
    public void setRepartidor(Repartidor repartidor) { this.repartidor = repartidor; }
    public Vehiculo getVehiculo() { return vehiculo; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }
    public EstadoPedido getEstado() { return estado; }
    public void setEstado(EstadoPedido estado) { this.estado = estado; }
    public Pedido getNext() { return next; }
    public void setNext(Pedido next) { this.next = next; }
    public Pedido getPrev() { return prev; }
    public void setPrev(Pedido prev) { this.prev = prev; }
}