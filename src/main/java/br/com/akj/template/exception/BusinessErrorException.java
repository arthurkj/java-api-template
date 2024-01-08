package br.com.akj.template.exception;

import br.com.akj.template.errors.Error;

public class BusinessErrorException extends AbstractErrorException {

    public BusinessErrorException(final Error error, final String reason) {
        super(error.getHttpStatus(), reason, error.getCode());
    }
}
