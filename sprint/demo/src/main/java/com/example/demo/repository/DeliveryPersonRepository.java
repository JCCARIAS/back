package model;

public class AVLTree {

    class Node {
        Cliente cliente;
        Node left, right;
        int height;

        Node(Cliente cliente) {
            this.cliente = cliente;
            this.height = 1;
        }
    }

    private Node root;

    private int height(Node N) {
        return (N == null) ? 0 : N.height;
    }

    private int getBalance(Node N) {
        return (N == null) ? 0 : height(N.left) - height(N.right);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    private Node insert(Node node, Cliente cliente) {
        if (node == null) return new Node(cliente);

        if (cliente.getCui().compareTo(node.cliente.getCui()) < 0)
            node.left = insert(node.left, cliente);
        else if (cliente.getCui().compareTo(node.cliente.getCui()) > 0)
            node.right = insert(node.right, cliente);
        else return node; // No duplicados

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && cliente.getCui().compareTo(node.left.cliente.getCui()) < 0)
            return rightRotate(node);

        if (balance < -1 && cliente.getCui().compareTo(node.right.cliente.getCui()) > 0)
            return leftRotate(node);

        if (balance > 1 && cliente.getCui().compareTo(node.left.cliente.getCui()) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && cliente.getCui().compareTo(node.right.cliente.getCui()) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void insertar(Cliente cliente) {
        root = insert(root, cliente);
    }

    public Cliente buscar(String cui) {
        return buscarNodo(root, cui);
    }

    private Cliente buscarNodo(Node node, String cui) {
        if (node == null) return null;

        if (cui.equals(node.cliente.getCui())) return node.cliente;
        if (cui.compareTo(node.cliente.getCui()) < 0)
            return buscarNodo(node.left, cui);
        else
            return buscarNodo(node.right, cui);
    }

    public void inOrden() {
        inOrdenRec(root);
    }

    private void inOrdenRec(Node node) {
        if (node != null) {
            inOrdenRec(node.left);
            System.out.println(node.cliente);
            inOrdenRec(node.right);
        }
    }
}
