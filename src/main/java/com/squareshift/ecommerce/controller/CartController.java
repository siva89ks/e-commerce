package com.squareshift.ecommerce.controller;

import com.squareshift.ecommerce.model.CartResponse;
import com.squareshift.ecommerce.model.CheckoutRequestBean;
import com.squareshift.ecommerce.model.Item;
import com.squareshift.ecommerce.model.ItemDetail;
import com.squareshift.ecommerce.validator.CartValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController implements CartApi {
    @Autowired
    CartValidator validator;

    @Override
    public CartResponse createCartItem(Item item, Errors errors) {
        validator.validateOnCreateItem(item,errors);
        checkError(errors);
        return null;
    }

    @Override
    public List<ItemDetail> findAllCartItems() {
        return null;
    }

    @Override
    public CartResponse removeCartItems() {
        return null;
    }

    @Override
    public List<ItemDetail> checkout(CheckoutRequestBean checkoutBean) {
        return null;
    }

    private void checkError(Errors errors) {

    }
}
