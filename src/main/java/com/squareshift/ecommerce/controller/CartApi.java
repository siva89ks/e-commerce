package com.squareshift.ecommerce.controller;

import com.squareshift.ecommerce.model.*;
import com.squareshift.ecommerce.exception.ProductException;
import com.squareshift.ecommerce.model.response.CartResponse;
import com.squareshift.ecommerce.model.response.ProductInfoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Api(tags = "E-Commerce Services", description = "Manage e-commerce related services")
public interface CartApi {
    @ApiOperation(value = "create new cart item", nickname = "createCartItem")
    @PostMapping(value = "/cart/item")
    public ResponseEntity<CartResponse> createCartItem(@RequestBody ItemDto itemDto, final Errors errors) throws ProductException;

    @ApiOperation(value = "Gets all the items in cart", nickname = "findAllCartItems")
    @GetMapping("/cart/items")
    public ResponseEntity<ProductInfoResponse> findAllCartItems() throws ProductException;

    @ApiOperation(value = "empty the cart", nickname = "removeCartItems")
    @DeleteMapping("/cart/items")
    public ResponseEntity<CartResponse> removeCartItems(@RequestBody RemoveCartDto removeCartDto) throws ProductException;

    @ApiOperation(value = "Gets all the items in cart", nickname = "findAllCartItems")
    @PostMapping("/cart/checkout-value")
    public ResponseEntity<CartResponse> checkout(@RequestParam(name = "shipping_postal_code") int postalCode) throws ProductException;
}
