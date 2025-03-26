package com.phonebook.util;

import com.phonebook.dto.OperatorDto;
import com.phonebook.model.Operator;

public class OperatorCreator {
    public static Operator addOperator() {
        return Operator.builder()
            .name("Test Operator")
            .category("Fixed")
            .price(5)
            .build();
    }

    public static OperatorDto addOperatorDto() {
        return new OperatorDto(
            1,
            "Test Operator",
            "Fixed",
            5,
            null
        );
    }
}