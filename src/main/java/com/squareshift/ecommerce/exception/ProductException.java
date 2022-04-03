package com.squareshift.ecommerce.exception;

public class ProductException extends Throwable {
    public ProductException() {
        super();
    }
    public ProductException(String message, Throwable cause) {
        super(message, cause);
    }
    public ProductException(String message) {
        super(message);
    }
    public ProductException(Throwable cause) {
        super(cause);
    }
    public ErrorBean getError() {
        return new ErrorBean();
    }
}
