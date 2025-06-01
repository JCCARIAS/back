package com.example.demo.service;

import model.AVLTree;
import model.Cliente;

public class ClienteService {
    private AVLTree arbolClientes = new AVLTree();

    public void agregarCliente(String cui, String nombre, String apellidos, String telefono, String direccion) {
        Cliente cliente = new Cliente(cui, nombre, apellidos, telefono, direccion);
        arbolClientes.insertar(cliente);
    }

    public Cliente buscarCliente(String cui) {
        return arbolClientes.buscar(cui);
    }

    public void listarClientes() {
        arbolClientes.inOrden();
    }
}
