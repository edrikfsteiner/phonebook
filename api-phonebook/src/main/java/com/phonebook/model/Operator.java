package com.phonebook.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "operators")
public class Operator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String category;
    private Integer price;
    @OneToMany(mappedBy="operator", cascade = CascadeType.ALL)
    private Set<Contact> contact;
}