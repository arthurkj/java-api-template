package br.com.akj.template.errors;

import static br.com.akj.template.errors.ErrorCode.CODE_0001;
import static br.com.akj.template.errors.ErrorCode.CODE_0002;
import static br.com.akj.template.errors.ErrorCode.CODE_0003;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum Error {

    INTERNAL_ERROR("internal.error", CODE_0001.getCode(), INTERNAL_SERVER_ERROR),
    INVALID_PARAMETERS("invalid.parameters", CODE_0002.getCode(), BAD_REQUEST),
    USER_NOT_FOUND("user.not.found", CODE_0003.getCode(), NOT_FOUND);

    private final String messageKey;
    private final String code;
    private final HttpStatus httpStatus;
}
