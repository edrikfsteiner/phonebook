package com.phonebook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.phonebook.model.Contact;
import com.phonebook.repositories.ContactRepository;

@Service
public class ContactService {
    @Autowired
    private ContactRepository repository;

    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> getContact(int id) {
        if (repository.countById(id) == 0) {
            return new ResponseEntity<>("Contact not found", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
        }   
    }

    public ResponseEntity<?> add(Contact contact) {
        if (contact.getName().equals("")) {
            return new ResponseEntity<>("Invalid name", HttpStatus.BAD_REQUEST);
        } else if(contact.getPhone().equals("")) {
            return new ResponseEntity<>("Invalid phone", HttpStatus.BAD_REQUEST);
        } else {
            repository.save(contact);
            return new ResponseEntity<>(contact, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> edit(Contact contact) {
        if (repository.countById(contact.getId()) == 0) {
            return new ResponseEntity<>("Contact not found", HttpStatus.NOT_FOUND);
        } else if (contact.getName().equals("")) {
            return new ResponseEntity<>("Invalid name", HttpStatus.BAD_REQUEST);
        } else if (contact.getPhone().equals("")) {
            return new ResponseEntity<>("Invalid phone", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(repository.save(contact), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> remove(int id) {
        if (repository.countById(id) == 0) {
            return new ResponseEntity<>("Contact not found", HttpStatus.NOT_FOUND);
        } else {
            Contact contact = repository.findById(id);
            repository.delete(contact);
            
            return new ResponseEntity<>("Contact deleted", HttpStatus.OK);
        }
    }
}