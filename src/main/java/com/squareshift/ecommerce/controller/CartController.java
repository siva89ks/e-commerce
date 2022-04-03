package com.squareshift.ecommerce.controller;

import com.squareshift.ecommerce.model.*;
import com.squareshift.ecommerce.exception.CartItemException;
import com.squareshift.ecommerce.exception.ProductException;
import com.squareshift.ecommerce.model.response.CartResponse;
import com.squareshift.ecommerce.model.response.ProductInfoResponse;
import com.squareshift.ecommerce.service.CartService;
import com.squareshift.ecommerce.validator.CartValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CartController implements CartApi {
    @Autowired
    CartValidator validator;
    @Autowired
    CartService cartService;

    @Override
    public ResponseEntity<CartResponse> createCartItem(ItemDto itemDto, Errors errors) throws ProductException {
        validator.validateOnCreateItem(itemDto,errors);
        checkError(errors);
        try {
            CartResponse saveResponse = cartService.saveCartItem(itemDto);
            return ResponseEntity.ok().body(saveResponse);
        }
        catch(CartItemException e){
            throw new ProductException();
        }
    }

    @Override
    public ResponseEntity<ProductInfoResponse> findAllCartItems() throws ProductException {
        try {
            ProductInfoResponse list = cartService.getAllCartItems();
            return ResponseEntity.ok().body(list);
        }
        catch(CartItemException e){
            throw new ProductException(e);
        }
    }

    @Override
    public ResponseEntity<CartResponse> removeCartItems(RemoveCartDto dto) throws ProductException {
        try {
            CartResponse response = cartService.removeCartResponse(dto);
            return ResponseEntity.ok().body(response);
        }
        catch(CartItemException e){
            throw new ProductException(e);
        }

    }

    @Override
    public ResponseEntity<CartResponse> checkout(int postalCode) throws ProductException {
        try {
           CartResponse response = cartService.checkoutTotalProductValue(postalCode);
            return ResponseEntity.ok().body(response);
        }
        catch(CartItemException e){
            throw new ProductException(e.getMessage(),e);
        }

    }

    private void checkError(Errors errors) {

    }
}
