package com.phonebook.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.phonebook.model.Contact;
import com.phonebook.services.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private ContactService service;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getContact(@PathVariable int id) {
        return service.getContact(id);
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody Contact contact) {
        return service.add(contact);
    }

    @PutMapping
    public ResponseEntity<?> edit(@RequestBody Contact contact) {
        return service.edit(contact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable int id) {
        return service.remove(id);
    }
}