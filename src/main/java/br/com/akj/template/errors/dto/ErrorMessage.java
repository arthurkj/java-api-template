package br.com.akj.template.errors.dto;

import org.springframework.validation.FieldError;

public record ErrorMessage(String field, String message) {

    private static final String VALOR_PADRAO_FIELD = "reason";

    public ErrorMessage(final String message) {
        this(VALOR_PADRAO_FIELD, message);
    }

    public ErrorMessage(final FieldError fieldError) {
        this(fieldError.getField(), fieldError.getDefaultMessage());
    }
}
