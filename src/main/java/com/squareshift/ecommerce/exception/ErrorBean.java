package com.squareshift.ecommerce.exception;

import lombok.Data;

@Data
public class ErrorBean {
    private String code;
    private String message;
    private String field;
}
