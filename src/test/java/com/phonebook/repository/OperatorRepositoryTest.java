package com.phonebook.repository;

import com.phonebook.model.Operator;
import com.phonebook.util.OperatorCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@DisplayName("Operator repository tests")
class OperatorRepositoryTest {
    @Autowired
    OperatorRepository repository;

    @Test
    @DisplayName("Returns a list of operators")
    public void shouldFindOperators() {
        List<Operator> operators = new ArrayList<>(List.of(OperatorCreator.addOperator()));
        List<Operator> savedOperators = operators.stream().map(repository::save).toList();

        Assertions.assertThat(savedOperators).isNotEmpty();
    }

    @Test
    @DisplayName("Returns an operator")
    public void shouldFindOperator() {
        Operator operator = OperatorCreator.addOperator();
        Operator savedOperator = this.repository.save(operator);
        Optional<Operator> operatorOpt = this.repository.findById(savedOperator.getId());

        Assertions.assertThat(operatorOpt).isNotEmpty();
    }

    @Test
    @DisplayName("Saves an operator")
    public void shouldSaveOperator() {
        Operator operator = OperatorCreator.addOperator();
        Operator savedOperator = this.repository.save(operator);

        Assertions.assertThat(savedOperator).isNotNull();
        Assertions.assertThat(savedOperator.getName()).isEqualTo(operator.getName());
        Assertions.assertThat(savedOperator.getCategory()).isEqualTo(operator.getCategory());
        Assertions.assertThat(savedOperator.getPrice()).isEqualTo(operator.getPrice());
    }

    @Test
    @DisplayName("Deletes an operator")
    public void shouldDeleteOperator() {
        Operator operator = OperatorCreator.addOperator();
        Operator savedOperator = this.repository.save(operator);
        this.repository.deleteById(savedOperator.getId());
        Optional<Operator> operatorOpt = this.repository.findById(savedOperator.getId());

        Assertions.assertThat(operatorOpt).isEmpty();
    }
}