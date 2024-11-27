package com.phonebook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phonebook.model.Operator;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Integer> {
    int countById(int id);

    Operator findById(int id);

    List<Operator> findAll();
}