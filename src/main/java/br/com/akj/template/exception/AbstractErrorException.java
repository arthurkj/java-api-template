package br.com.akj.template.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.akj.template.errors.dto.ErrorMessage;
import lombok.Getter;

@Getter
public abstract class AbstractErrorException extends ResponseStatusException {

    private final String code;
    private final List<ErrorMessage> errors;

    protected AbstractErrorException(final HttpStatus status, final String reason, final String code) {
        super(status, reason);
        this.code = code;
        this.errors = new ArrayList<>();
    }
}
