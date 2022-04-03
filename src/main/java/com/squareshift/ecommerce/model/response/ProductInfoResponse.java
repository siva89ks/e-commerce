package com.squareshift.ecommerce.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.squareshift.ecommerce.model.ItemDto;
import com.squareshift.ecommerce.model.response.CartResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductInfoResponse extends CartResponse {

    @JsonProperty("items")
    private List<ItemDto> itemDtos;

    public String status;

    public String message;
}
