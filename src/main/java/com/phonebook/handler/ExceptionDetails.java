package com.phonebook.handler;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ExceptionDetails {
    private LocalDateTime timestamp;
    private Integer status;
    private String details;
}