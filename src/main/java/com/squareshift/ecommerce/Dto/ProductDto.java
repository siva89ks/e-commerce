package com.squareshift.ecommerce.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements BaseDto{

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private float price;

    @JsonProperty("description")
    private String description;

    @JsonProperty("category")
    private String category;

    @JsonProperty("image")
    private String image;

    @JsonProperty("discount_percentage")
    private float discountPercentage;

    @JsonProperty("weight_in_grams")
    private int weightInGrams;


}
