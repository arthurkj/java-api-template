package br.com.akj.template.resource.handler;

import static br.com.akj.template.errors.Error.INTERNAL_ERROR;
import static br.com.akj.template.errors.Error.INVALID_PARAMETERS;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.akj.template.errors.Error;
import br.com.akj.template.errors.dto.ErrorDTO;
import br.com.akj.template.errors.dto.ErrorMessage;
import br.com.akj.template.exception.AbstractErrorException;
import br.com.akj.template.helper.MessageHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
@Component
public class ValidationHandler {

    private static final String MESSAGE_ERROR_LOG = "Error on API";

    private final MessageHelper messageHelper;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleInternalError(final Exception exception) {
        log.error(MESSAGE_ERROR_LOG, exception);

        final ErrorDTO errorInfo = new ErrorDTO(exception);

        return new ResponseEntity<>(errorInfo, INTERNAL_ERROR.getHttpStatus());
    }

    @ExceptionHandler(AbstractErrorException.class)
    public ResponseEntity<ErrorDTO> handleGenericException(final AbstractErrorException exception) {
        log.error(MESSAGE_ERROR_LOG, exception);

        final ErrorDTO errorInfo = new ErrorDTO(exception);

        return new ResponseEntity<>(errorInfo, exception.getStatusCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleInvalidParameters(final MethodArgumentNotValidException exception) {
        log.error(MESSAGE_ERROR_LOG, exception);
        final Error error = INVALID_PARAMETERS;

        final List<ErrorMessage> parametrosComErro = exception.getFieldErrors().stream()
            .map(ErrorMessage::new).toList();

        final ErrorDTO errorInfo = new ErrorDTO(error, messageHelper.get(error, exception.getMessage()),
            parametrosComErro);

        return new ResponseEntity<>(errorInfo, error.getHttpStatus());
    }
}
