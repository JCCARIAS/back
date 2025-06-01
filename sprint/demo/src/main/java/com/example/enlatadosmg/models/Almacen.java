package com.example.enlatadosmg.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "almacen")
public class Almacen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer correlativo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;

    @ManyToOne
    @JoinColumn(name = "next_correlativo")
    private Almacen next;


    public Integer getCorrelativo() { return correlativo; }
    public void setCorrelativo(Integer correlativo) { this.correlativo = correlativo; }
    public Date getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(Date fechaIngreso) { this.fechaIngreso = fechaIngreso; }
    public Almacen getNext() { return next; }
    public void setNext(Almacen next) { this.next = next; }
}