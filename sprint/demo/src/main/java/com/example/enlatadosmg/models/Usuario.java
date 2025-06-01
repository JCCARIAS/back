package com.example.enlatadosmg.models;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apellidos;
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "next_id")
    private Usuario next;

    @ManyToOne
    @JoinColumn(name = "prev_id")
    private Usuario prev;

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    public Usuario getNext() { return next; }
    public void setNext(Usuario next) { this.next = next; }
    public Usuario getPrev() { return prev; }
    public void setPrev(Usuario prev) { this.prev = prev; }
}