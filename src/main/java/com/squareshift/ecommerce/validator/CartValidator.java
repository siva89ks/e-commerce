package com.squareshift.ecommerce.validator;

import com.squareshift.ecommerce.model.ItemDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class CartValidator {
    public void validateOnCreateItem(ItemDto itemDto, Errors errors) {
    }
}
