package com.squareshift.ecommerce.exception;

public class NoDataException extends Throwable {
    public ErrorBean getError() {
        return new ErrorBean();
    }
}
