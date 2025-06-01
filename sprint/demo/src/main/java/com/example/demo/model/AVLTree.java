package com.example.demo.model;

import jakarta.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "delivery_persons")
@Getter @Setter
@ToString
@EqualsAndHashCode
public class AVLTree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String phone;
    private String address;

    // Getters y Setters
}
