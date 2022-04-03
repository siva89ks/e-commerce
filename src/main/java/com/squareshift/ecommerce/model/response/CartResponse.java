package com.squareshift.ecommerce.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CartResponse {

   @JsonProperty("status")
   public String status;

   @JsonProperty("message")
   public String message;
}
