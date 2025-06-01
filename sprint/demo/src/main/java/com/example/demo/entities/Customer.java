package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Table(name="customers")
@Getter @Setter
@ToString
@EqualsAndHashCode
@Entity
public class Customer {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
    private String name;
    private String email;        // Número de identificación tributaria, importante para clientes
    private String phone;
    private String address;

}
