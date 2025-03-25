package com.phonebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phonebook.model.Operator;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Integer> {}