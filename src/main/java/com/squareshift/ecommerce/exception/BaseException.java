package com.squareshift.ecommerce.exception;

import lombok.Builder;
import org.springframework.http.HttpStatus;

public class BaseException  extends  Exception{

    @Builder.Default
    HttpStatus status = HttpStatus.OK;

    public BaseException(HttpStatus status) {
        this.status = status;
    }
    public BaseException(String message){
        super(message);
    }

    public BaseException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public BaseException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        this.status = status;
    }

    public BaseException(Throwable cause, HttpStatus status) {
        super(cause);
        this.status = status;
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, HttpStatus status) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.status = status;
    }
}
