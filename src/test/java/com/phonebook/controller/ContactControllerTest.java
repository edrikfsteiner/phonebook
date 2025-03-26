package com.phonebook.controller;

import com.phonebook.dto.ContactDto;
import com.phonebook.service.ContactService;
import com.phonebook.util.ContactCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DisplayName("Contact controller tests")
class ContactControllerTest {
    @InjectMocks
    private ContactController controller;
    @Mock
    private ContactService service;

    @BeforeEach
    void setup() {
        ContactDto contact = ContactCreator.addContactDto();
        List<ContactDto> contacts = new ArrayList<>(List.of(contact));

        BDDMockito.when(service.getAll())
            .thenReturn(contacts);
        BDDMockito.when(service.getById(ArgumentMatchers.anyInt()))
            .thenReturn(contact);
        BDDMockito.when(service.add(ArgumentMatchers.any(ContactDto.class)))
            .thenReturn(contact);
        BDDMockito.when(service.edit(ArgumentMatchers.any(ContactDto.class)))
            .thenReturn(contact);
    }

    @Test
    @DisplayName("Returns a 200 status code when get all")
    void shouldReturnOkWhenGetContacts() {
        List<ContactDto> contacts = new ArrayList<>(List.of(ContactCreator.addContactDto()));
        ResponseEntity<?> response = controller.getAll();

        Assertions.assertThat(response.getStatusCode()).isEqualTo(404);
    }

    @Test
    @DisplayName("Returns a 500 exception when get all")
    void shouldReturnInternalServerErrorWhenGetAll() {
        ResponseEntity<?> response = controller.getAll();

        Assertions.assertThat(response.getStatusCode()).isEqualTo(500);
    }

    @Test
    @DisplayName("Returns a 200 status code when get by id")
    void shouldReturnOkWhenGetContact() {
        ContactDto contact = ContactCreator.addContactDto();
        ResponseEntity<?> response = controller.getById(1);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
    }

    @Test
    @DisplayName("Returns a 404 exception when get by id")
    void shouldReturnNotFoundWhenGetById() {
        ResponseEntity<?> response = controller.getById(1);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(404);
    }

    @Test
    @DisplayName("Returns a 500 exception when get by id")
    void shouldReturnInternalServerErrorWhenGetById() {
        ResponseEntity<?> response = controller.getById(1);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(500);
    }

    @Test
    @DisplayName("Returns a 200 status code when add contact")
    void shouldReturnOkWhenAddContact() {
        ContactDto contact = ContactCreator.addContactDto();
        ResponseEntity<?> response = controller.add(contact);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
    }

    @Test
    @DisplayName("Returns a 400 exception when add contact")
    void shouldReturnBadRequestWhenAddContact() {
        // create contact manually here

        ContactDto contact = ContactCreator.addContactDto();
        ResponseEntity<?> response = controller.add(contact);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(404);
    }

    @Test
    @DisplayName("Returns a 500 exception when add contact")
    void shouldReturnInternalServerErrorWhenAddContact() {
        // don't know how the fuck I will make a server error
        // please think it better

        ContactDto contact = ContactCreator.addContactDto();
        ResponseEntity<?> response = controller.add(contact);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(500);
    }
}