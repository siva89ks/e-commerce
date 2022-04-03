package com.squareshift.ecommerce.service.RemoteService;

import com.squareshift.ecommerce.Dto.ProductDto;
import com.squareshift.ecommerce.model.WarehouseDto;
import com.squareshift.ecommerce.model.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    WebClient webClient;


    public Mono<ProductResponse> getProductDetails(long id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/product/{id}").build(id))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(ProductResponse.class);
    }



    public Mono<WarehouseDto> getDistanceForDelhv_Address(long postalCode) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/warehouse/distance").queryParam("postal_code",postalCode).build())
                .retrieve()
                .bodyToMono(WarehouseDto.class);
    }

}
