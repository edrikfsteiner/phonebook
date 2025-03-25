package com.phonebook.controller;

import com.phonebook.dto.ContactDto;
import com.phonebook.exception.BadRequestException;
import com.phonebook.exception.InternalServerException;
import com.phonebook.exception.NotFoundException;
import com.phonebook.handler.RestExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.phonebook.service.ContactService;

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
    @Autowired
    private RestExceptionHandler handler;

    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(service.getAll());
        } catch (NotFoundException ex) {
            return handler.handleNotFound(ex);
        } catch (InternalServerException ex) {
            return handler.handleInternalServer(ex);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.getById(id));
        } catch (NotFoundException ex) {
            return handler.handleNotFound(ex);
        } catch (InternalServerException ex) {
            return handler.handleInternalServer(ex);
        }
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody ContactDto contact) {
        try {
            return ResponseEntity.ok(service.add(contact));
        } catch (BadRequestException ex) {
            return handler.handleBadRequest(ex);
        } catch (InternalServerException ex) {
            return handler.handleInternalServer(ex);
        }
    }

    @PutMapping
    public ResponseEntity<?> edit(@RequestBody ContactDto contact) {
        try {
            return ResponseEntity.ok(service.edit(contact));
        } catch (BadRequestException ex) {
            return handler.handleBadRequest(ex);
        } catch (InternalServerException ex) {
            return handler.handleInternalServer(ex);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable Integer id) {
        try {
            service.delete(id);
            return ResponseEntity.ok("Contact deleted");
        } catch (NotFoundException ex) {
            return handler.handleNotFound(ex);
        } catch (InternalServerException ex) {
            return handler.handleInternalServer(ex);
        }
    }
}