package com.phonebook.repository;

import com.phonebook.model.Contact;
import com.phonebook.util.ContactCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@DisplayName("Contact repository tests")
class ContactRepositoryTest {
    @Autowired
    private ContactRepository repository;

    @Test
    @DisplayName("Returns a list of contacts")
    public void shouldFindContacts() {
        List<Contact> contacts = new ArrayList<>(List.of(ContactCreator.addContact()));
        List<Contact> savedContacts = contacts.stream().map(repository::save).toList();

        Assertions.assertThat(savedContacts).isNotEmpty();
    }

    @Test
    @DisplayName("Returns a contact")
    public void shouldFindContact() {
        Contact contact = ContactCreator.addContact();
        Contact savedContact = this.repository.save(contact);
        Optional<Contact> contactOpt = this.repository.findById(savedContact.getId());

        Assertions.assertThat(contactOpt).isNotEmpty();
    }

    @Test
    @DisplayName("Saves a contact")
    public void shouldSaveContact() {
        Contact contact = ContactCreator.addContact();
        Contact savedContact = this.repository.save(contact);

        Assertions.assertThat(savedContact).isNotNull();
        Assertions.assertThat(savedContact.getName()).isEqualTo(contact.getName());
        Assertions.assertThat(savedContact.getPhone()).isEqualTo(contact.getPhone());
    }

    @Test
    @DisplayName("Deletes a contact")
    public void shouldDeleteContact() {
        Contact contact = ContactCreator.addContact();
        Contact savedContact = this.repository.save(contact);
        this.repository.deleteById(contact.getId());
        Optional<Contact> contactOpt = this.repository.findById(savedContact.getId());

        Assertions.assertThat(contactOpt).isEmpty();
    }
}