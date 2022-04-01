package com.squareshift.ecommerce.validator;

import com.squareshift.ecommerce.model.Item;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class CartValidator {
    public void validateOnCreateItem(Item item, Errors errors) {
    }
}
