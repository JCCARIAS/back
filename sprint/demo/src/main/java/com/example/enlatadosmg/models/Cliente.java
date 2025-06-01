package com.example.enlatadosmg.models;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    private String cui;

    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "left_cui")
    private Cliente left;

    @ManyToOne
    @JoinColumn(name = "right_cui")
    private Cliente right;

    private int height = 1;

    // Getters and Setters
    public String getCui() { return cui; }
    public void setCui(String cui) { this.cui = cui; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public Cliente getLeft() { return left; }
    public void setLeft(Cliente left) { this.left = left; }
    public Cliente getRight() { return right; }
    public void setRight(Cliente right) { this.right = right; }
    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }
}