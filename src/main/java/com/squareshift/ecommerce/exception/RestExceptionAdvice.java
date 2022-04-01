package com.squareshift.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionAdvice {
    @ExceptionHandler(NoDataException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ErrorResponse prepareNoDataException(final NoDataException ex) {
        final ErrorResponse response = ErrorResponse.create().message(ex.getMessage()).addError(ex.getError());
        return response;
    }
}
