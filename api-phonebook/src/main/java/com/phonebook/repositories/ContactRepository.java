package com.phonebook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phonebook.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    int countById(int id);

    Contact findById(int id);

    List<Contact> findAll();
}