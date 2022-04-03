package com.squareshift.ecommerce.exception;

import lombok.Builder;
import org.springframework.http.HttpStatus;

public class CartItemException extends BaseException {


    public CartItemException(HttpStatus status) {
        super(status);
    }

    public CartItemException(String message) {
        super(message);
    }

    public CartItemException(String message, HttpStatus status) {
        super(message, status);
    }

    public CartItemException(String message, Throwable cause, HttpStatus status) {
        super(message, cause, status);
    }

    public CartItemException(Throwable cause, HttpStatus status) {
        super(cause, status);
    }

    public CartItemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, HttpStatus status) {
        super(message, cause, enableSuppression, writableStackTrace, status);
    }
}
