package com.squareshift.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareshift.ecommerce.dto.BaseDto;
import com.squareshift.ecommerce.entity.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto implements BaseDto {

    @JsonProperty("product_id")
    Long productId;
    @JsonProperty("quantity")
    Integer quantity;
    @JsonProperty("description")
    String description;

    public ItemDto(ItemEntity itemEntity) {
        this.productId = itemEntity.getProductId();
        this.description = itemEntity.getDescription();
        this.quantity = itemEntity.getQuantity();
    }
}
