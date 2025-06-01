package com.example.enlatadosmg.service;
import com.example.enlatadosmg.models.Cliente;
import com.example.enlatadosmg.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    private Cliente root;

    public Cliente insert(Cliente cliente) {
        root = insert(root, cliente);
        return clienteRepository.save(cliente);
    }

    private Cliente insert(Cliente node, Cliente cliente) {
        if (node == null) {
            return cliente;
        }

        if (cliente.getCui().compareTo(node.getCui()) < 0) {
            node.setLeft(insert(node.getLeft(), cliente));
        } else if (cliente.getCui().compareTo(node.getCui()) > 0) {
            node.setRight(insert(node.getRight(), cliente));
        } else {
            return node; // Duplicate CUIs not allowed
        }

        // Update height
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));

        // Balance factor
        int balance = getBalance(node);

        // Perform rotations if needed
        if (balance > 1 && cliente.getCui().compareTo(node.getLeft().getCui()) < 0) {
            return rightRotate(node);
        }

        if (balance < -1 && cliente.getCui().compareTo(node.getRight().getCui()) > 0) {
            return leftRotate(node);
        }

        if (balance > 1 && cliente.getCui().compareTo(node.getLeft().getCui()) > 0) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        if (balance < -1 && cliente.getCui().compareTo(node.getRight().getCui()) < 0) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        return node;
    }

    private int height(Cliente node) {
        return node == null ? 0 : node.getHeight();
    }

    private int getBalance(Cliente node) {
        return node == null ? 0 : height(node.getLeft()) - height(node.getRight());
    }

    private Cliente rightRotate(Cliente y) {
        Cliente x = y.getLeft();
        Cliente T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);

        return x;
    }

    private Cliente leftRotate(Cliente x) {
        Cliente y = x.getRight();
        Cliente T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        return y;
    }

    // Other AVL operations (search, delete, etc.)
}