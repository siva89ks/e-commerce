package com.squareshift.ecommerce.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareshift.ecommerce.dto.ProductDto;
import lombok.Data;

@Data
public class ProductResponse {

    @JsonProperty("status")
    private String status;

    @JsonProperty("product")
    private ProductDto productDto;
}
