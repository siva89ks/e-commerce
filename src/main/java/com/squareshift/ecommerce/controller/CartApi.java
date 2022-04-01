package com.squareshift.ecommerce.controller;

import com.squareshift.ecommerce.model.CartResponse;
import com.squareshift.ecommerce.model.CheckoutRequestBean;
import com.squareshift.ecommerce.model.Item;
import com.squareshift.ecommerce.model.ItemDetail;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "E-Commerce Services", description = "Manage e-commerce related services")
public interface CartApi {
    @ApiOperation(value = "create new cart item", nickname = "createCartItem")
    @PostMapping(value = "/cart/item")
    public CartResponse createCartItem(@RequestBody Item item, final org.springframework.validation.Errors errors);

    @ApiOperation(value = "Gets all the items in cart", nickname = "findAllCartItems")
    @GetMapping("/cart/items")
    public List<ItemDetail> findAllCartItems();

    @ApiOperation(value = "empty the cart", nickname = "removeCartItems")
    @DeleteMapping("/cart/items")
    public CartResponse removeCartItems();

    @ApiOperation(value = "Gets all the items in cart", nickname = "findAllCartItems")
    @PostMapping("/cart/checkout-value")
    public List<ItemDetail> checkout(@RequestBody CheckoutRequestBean checkoutBean);
}
