package com.phonebook.controller;

import com.phonebook.dto.OperatorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import com.phonebook.service.OperatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/operators")
public class OperatorController {
    @Autowired
    private OperatorService service;

    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            List<OperatorDto> operators = service.getAll();
            return ResponseEntity.ok(operators);
        } catch (Exception e) {
            return new ResponseEntity<>("No operators found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOperator(@PathVariable Integer id) {
        try {
            OperatorDto operator = service.getById(id);
            return ResponseEntity.ok(operator);
        } catch (Exception e) {
            return new ResponseEntity<>("Operator not found", HttpStatus.NOT_FOUND);
        }
    }
}