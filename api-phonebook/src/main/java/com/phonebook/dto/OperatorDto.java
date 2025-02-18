package com.phonebook.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record OperatorDto(
    Integer id,
    @NotBlank(message = "Invalid name")
    String name,
    @NotBlank(message = "Invalid category")
    String category,
    @NotBlank(message = "Invalid price")
    Integer price,
    List<Integer> contacts
) {}