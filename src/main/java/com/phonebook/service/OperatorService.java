package com.phonebook.service;

import com.phonebook.dto.OperatorDto;
import com.phonebook.exception.NotFoundException;
import com.phonebook.mapper.OperatorMapper;
import com.phonebook.model.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebook.repository.OperatorRepository;

import java.util.List;

@Service
public class OperatorService {
    @Autowired
    private OperatorRepository repository;

    public List<OperatorDto> getAll() {
        List<Operator> operators = repository.findAll();

        if (operators.isEmpty()) {
            throw new NotFoundException("No operators found");
        }

        return operators.stream().map(OperatorMapper::toDTO).toList();
    }

    public OperatorDto getById(Integer id) {
        return OperatorMapper.toDTO(
            repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Contact not found"))
        );
    }
}