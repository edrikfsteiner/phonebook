package com.phonebook.mapper;

import com.phonebook.dto.OperatorDto;
import com.phonebook.model.Contact;
import com.phonebook.model.Operator;

import java.util.List;

public class OperatorMapper {
    public static OperatorDto toDTO(Operator model) {
        return new OperatorDto(
            model.getId(),
            model.getName(),
            model.getCategory(),
            model.getPrice(),
            model.getContacts().stream().map(Contact::getId).toList()
        );
    }

    public static Operator toModel(OperatorDto dto) {
        List<Contact> contacts = dto.contacts()
            .stream()
            .map(id -> Contact.builder()
                .id(id)
                .build())
            .toList();

        return Operator.builder()
            .id(dto.id())
            .name(dto.name())
            .category(dto.category())
            .price(dto.price())
            .contacts(contacts)
            .build();
    }
}