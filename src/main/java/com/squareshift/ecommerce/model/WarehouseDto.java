package com.squareshift.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WarehouseDto {

    @JsonProperty("postal_code")
    int postalCode;

    @JsonProperty("distance_in_kilometers")
    int distance;
}
