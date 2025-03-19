package com.phonebook.mapper;

import com.phonebook.dto.ContactDto;
import com.phonebook.model.Contact;
import com.phonebook.model.Operator;

public class ContactMapper {
    public static ContactDto toDTO(Contact model) {
        return new ContactDto(
            model.getId(),
            model.getName(),
            model.getPhone(),
            model.getOperator() != null ? model.getOperator().getId() : null
        );
    }

    public static Contact toModel(ContactDto dto) {
        Operator operator = Operator.builder()
            .id(dto.operator())
            .build();

        return Contact.builder()
            .id(dto.id())
            .name(dto.name())
            .phone(dto.phone())
            .operator(operator)
            .build();
    }
}