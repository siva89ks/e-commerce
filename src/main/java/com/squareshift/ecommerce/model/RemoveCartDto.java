package com.squareshift.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareshift.ecommerce.Dto.BaseDto;
import lombok.Data;

@Data
public class RemoveCartDto implements BaseDto {

    @JsonProperty(value = "action" ,required = true)
    private String action;
}
