package br.com.akj.template.exception;


import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import br.com.akj.template.errors.Error;

public class InternalErrorException extends AbstractErrorException {

    public InternalErrorException(final Error errorCode, final String reason) {
        super(INTERNAL_SERVER_ERROR, reason, errorCode.getCode());
    }
}