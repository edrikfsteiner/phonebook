package com.phonebook.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
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
    private List<Contact> contacts;
}