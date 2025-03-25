package com.phonebook.service;

import com.phonebook.dto.ContactDto;
import com.phonebook.exception.BadRequestException;
import com.phonebook.exception.NotFoundException;
import com.phonebook.mapper.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebook.model.Contact;
import com.phonebook.repository.ContactRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepository repository;

    public List<ContactDto> getAll() {
        List<Contact> contacts = repository.findAll();

        if (contacts.isEmpty()) {
            throw new NotFoundException("No contacts found");
        }

        return contacts.stream().map(ContactMapper::toDTO).toList();
    }

    public ContactDto getById(Integer id) {
        return ContactMapper.toDTO(
            repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Contact not found"))
        );
    }

    @Transactional
    public ContactDto add(ContactDto dto) {
        if (dto.name().isEmpty()) {
            throw new BadRequestException("Invalid name");
        } else if (dto.phone().isEmpty()) {
            throw new BadRequestException("Invalid phone");
        }

        return ContactMapper.toDTO(repository.save(ContactMapper.toModel(dto)));
    }

    @Transactional
    public ContactDto edit(ContactDto dto) {
        Optional<Contact> contactOpt = repository.findById(dto.id());

        if (contactOpt.isEmpty()) {
            throw new NotFoundException("Contact not found");
        } else if (dto.name().isEmpty()) {
            throw new BadRequestException("Invalid name");
        } else if (dto.phone().isEmpty()) {
            throw new BadRequestException("Invalid phone");
        }

        return ContactMapper.toDTO(repository.save(ContactMapper.toModel(dto)));
    }

    @Transactional
    public void delete(Integer id) {
        repository.findById(id)
            .orElseThrow(() -> new NotFoundException("Contact not found"));

        repository.deleteById(id);
    }
}