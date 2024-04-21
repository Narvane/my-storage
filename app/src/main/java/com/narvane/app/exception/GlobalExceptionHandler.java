package com.narvane.app.exception;

import com.narvane.app.exception.details.ApiValidationExceptionDetails;
import com.narvane.exception.ValidationServiceException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(ValidationServiceException.class)
    public ResponseEntity<String> handleValidationServiceExceptions(ValidationServiceException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(messageSource.getMessage(
                        e.getMessage(), null, null, LocaleContextHolder.getLocale()
                ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiValidationExceptionDetails> handleApiValidationExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = getInternationalizedMessage(error.getDefaultMessage());
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiValidationExceptionDetails.builder()
                        .baseMessage(getInternationalizedMessage("some.arguments.are.not.valid"))
                        .details(errors)
                        .build());
    }

    private String getInternationalizedMessage(String message) {
        return messageSource.getMessage(
                Objects.requireNonNull(message),
                null,
                null,
                LocaleContextHolder.getLocale()
        );
    }

}
