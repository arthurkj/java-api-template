package br.com.akj.template.errors.dto;

import org.springframework.validation.FieldError;

public record ErrorMessage(String field, String message) {

    private static final String FIELD_DEFAULT_VALUE = "reason";

    public ErrorMessage(final String message) {
        this(FIELD_DEFAULT_VALUE, message);
    }

    public ErrorMessage(final FieldError fieldError) {
        this(fieldError.getField(), fieldError.getDefaultMessage());
    }
}
