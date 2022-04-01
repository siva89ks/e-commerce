package com.squareshift.ecommerce.exception;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {
    private String message;
    private List<ErrorBean> errors;

    public static ErrorResponse create() {
        return new ErrorResponse();
    }
    public ErrorResponse message(final String message) {
        this.message = message;
        return this;
    }
    public ErrorResponse addError(final ErrorBean error) {
        if (this.errors == null) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(error);
        return this;
    }
    public List<ErrorBean> getErrors() {
        return errors;
    }

}
