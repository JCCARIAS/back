package com.example.enlatadosmg.models;

import javax.persistence.*;

@Entity
@Table(name = "cajas_por_pedido")
public class CajaPorPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "almacen_correlativo")
    private Almacen almacen;

    @ManyToOne
    @JoinColumn(name = "next_id")
    private CajaPorPedido next;

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Pedido getPedido() { return pedido; }
    public void setPedido(Pedido pedido) { this.pedido = pedido; }
    public Almacen getAlmacen() { return almacen; }
    public void setAlmacen(Almacen almacen) { this.almacen = almacen; }
    public CajaPorPedido getNext() { return next; }
    public void setNext(CajaPorPedido next) { this.next = next; }
}
