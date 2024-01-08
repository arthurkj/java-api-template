package br.com.akj.template.errors.dto;

import static br.com.akj.template.errors.Error.INTERNAL_ERROR;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

import java.time.LocalDateTime;
import java.util.List;

import br.com.akj.template.errors.Error;
import br.com.akj.template.exception.AbstractErrorException;

public record ErrorDTO(LocalDateTime timestamp, String message, String code, List<ErrorMessage> errors) {

    private static final String INTERNAL_ERROR_MESSAGE = "Internal Error";

    public ErrorDTO(final Exception exception) {
        this(LocalDateTime.now(), INTERNAL_ERROR_MESSAGE, INTERNAL_ERROR.getCode(),
            singletonList(new ErrorMessage(exception.getMessage())));
    }

    public ErrorDTO(final AbstractErrorException exception) {
        this(LocalDateTime.now(), exception.getReason(), exception.getCode(), exception.getErrors());
    }

    public ErrorDTO(final Error error, final String message) {
        this(LocalDateTime.now(), message, error.getCode(), emptyList());
    }

    public ErrorDTO(final Error error, final String message, final List<ErrorMessage> errorsMessage) {
        this(LocalDateTime.now(), message, error.getCode(), errorsMessage);
    }
}
