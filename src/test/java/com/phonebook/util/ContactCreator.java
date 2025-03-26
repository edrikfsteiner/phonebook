package com.phonebook.util;

import com.phonebook.dto.ContactDto;
import com.phonebook.model.Contact;

public class ContactCreator {
    public static Contact addContact() {
        return Contact.builder()
            .name("Carlos")
            .phone("1111-1111")
            .build();
    }

    public static ContactDto addContactDto() {
        return new ContactDto(
            1,
            "Carlos",
            "1111-1111",
            null
        );
    }
}