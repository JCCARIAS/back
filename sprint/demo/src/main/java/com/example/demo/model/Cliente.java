package com.example.demo.model;

public class Cliente {
    private String cui;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;

    public Cliente(String cui, String nombre, String apellidos, String telefono, String direccion) {
        this.cui = cui;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getCui() { return cui; }
    public String getNombre() { return nombre; }
    public String getApellidos() { return apellidos; }
    public String getTelefono() { return telefono; }
    public String getDireccion() { return direccion; }

    @Override
    public String toString() {
        return "Cliente{" +
                "cui='" + cui + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}

