package com.example.enlatadosmg.models;

import javax.persistence.*;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    private String placa;

    private String marca;
    private String modelo;
    private String color;
    private int año;
    private String tipoTransmision;
    private boolean disponible = true;

    @ManyToOne
    @JoinColumn(name = "next_placa")
    private Vehiculo next;

    // Getters and Setters
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public int getAño() { return año; }
    public void setAño(int año) { this.año = año; }
    public String getTipoTransmision() { return tipoTransmision; }
    public void setTipoTransmision(String tipoTransmision) { this.tipoTransmision = tipoTransmision; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    public Vehiculo getNext() { return next; }
    public void setNext(Vehiculo next) { this.next = next; }
}
