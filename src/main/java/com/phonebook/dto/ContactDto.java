package com.phonebook.dto;

import jakarta.validation.constraints.NotBlank;

public record ContactDto(
    Integer id,
    @NotBlank(message = "Invalid name")
    String name,
    @NotBlank(message = "Invalid phone")
    String phone,
    Integer operator
) {}