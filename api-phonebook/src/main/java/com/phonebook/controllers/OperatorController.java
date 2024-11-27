package com.phonebook.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.phonebook.services.OperatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/operators")
public class OperatorController {
    @Autowired
    private OperatorService service;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOperator(@PathVariable int id) {
        return service.getOperator(id);
    }
}