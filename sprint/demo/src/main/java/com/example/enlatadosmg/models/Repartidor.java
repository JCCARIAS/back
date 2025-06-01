package com.example.enlatadosmg.models;

import javax.persistence.*;

@Entity
@Table(name = "repartidores")
public class Repartidor {
    @Id
    private String cui;

    private String nombre;
    private String apellidos;

    @Enumerated(EnumType.STRING)
    private TipoLicencia licencia;

    private String telefono;
    private boolean disponible = true;

    @ManyToOne
    @JoinColumn(name = "next_cui")
    private Repartidor next;

    public enum TipoLicencia {
        A, B, C
    }

    // Getters and Setters
    public String getCui() { return cui; }
    public void setCui(String cui) { this.cui = cui; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public TipoLicencia getLicencia() { return licencia; }
    public void setLicencia(TipoLicencia licencia) { this.licencia = licencia; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    public Repartidor getNext() { return next; }
    public void setNext(Repartidor next) { this.next = next; }
}
