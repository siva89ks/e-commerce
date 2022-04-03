package com.squareshift.ecommerce.service;

import com.squareshift.ecommerce.model.*;
import com.squareshift.ecommerce.exception.CartItemException;
import com.squareshift.ecommerce.model.response.CartResponse;
import com.squareshift.ecommerce.model.response.ProductInfoResponse;

public interface CartService {

    CartResponse saveCartItem(ItemDto itemDto) throws CartItemException;

    ProductInfoResponse getAllCartItems() throws  CartItemException;
    CartResponse removeCartResponse(RemoveCartDto dto) throws  CartItemException;

    CartResponse checkoutTotalProductValue(long postalCode) throws  CartItemException;
}
