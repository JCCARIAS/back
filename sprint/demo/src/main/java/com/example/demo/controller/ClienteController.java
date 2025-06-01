package com.example.demo.controller;



import com.example.demo.service.ClienteService;
import java.util.Scanner;

public class ClienteController {
    private ClienteService clienteService = new ClienteService();

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Clientes ---");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Buscar cliente");
            System.out.println("3. Listar clientes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("CUI: ");
                    String cui = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellidos: ");
                    String apellidos = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = scanner.nextLine();

                    clienteService.agregarCliente(cui, nombre, apellidos, telefono, direccion);
                    break;

                case 2:
                    System.out.print("CUI a buscar: ");
                    String cuiBuscar = scanner.nextLine();
                    var cliente = clienteService.buscarCliente(cuiBuscar);
                    if (cliente != null)
                        System.out.println(cliente);
                    else
                        System.out.println("Cliente no encontrado.");
                    break;

                case 3:
                    clienteService.listarClientes();
                    break;
            }
        } while (opcion != 4);
    }
}
