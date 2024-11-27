package com.phonebook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.phonebook.repositories.OperatorRepository;

@Service
public class OperatorService {
    @Autowired
    private OperatorRepository repository;

    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> getOperator(int id) {
        if (repository.countById(id) == 0) {
            return new ResponseEntity<>("Operator not found", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
        }   
    }
}