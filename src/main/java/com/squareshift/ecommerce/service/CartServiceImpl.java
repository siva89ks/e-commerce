package com.squareshift.ecommerce.service;


import com.squareshift.ecommerce.dto.ProductDto;
import com.squareshift.ecommerce.model.WarehouseDto;
import com.squareshift.ecommerce.model.response.ProductInfoResponse;
import com.squareshift.ecommerce.adapter.ItemAdapter;
import com.squareshift.ecommerce.exception.CartItemException;
import com.squareshift.ecommerce.model.response.CartResponse;
import com.squareshift.ecommerce.model.ItemDto;
import com.squareshift.ecommerce.model.RemoveCartDto;
import com.squareshift.ecommerce.model.response.ProductResponse;
import com.squareshift.ecommerce.repository.ItemRepository;
import com.squareshift.ecommerce.service.RemoteService.ProductService;
import com.squareshift.ecommerce.utils.Constants;
import com.squareshift.ecommerce.utils.WeightDistancePriceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
public class CartServiceImpl implements CartService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemAdapter itemAdapter;

    @Autowired
    ProductService service;

    @Autowired
    WeightDistancePriceMapper mapper;


    @Override
    public CartResponse saveCartItem(ItemDto itemDto) throws CartItemException {
        CartResponse response = new CartResponse();
        try{
            itemRepository.save(itemAdapter.saveEntity(itemDto));
            response.setMessage(Constants.MESSAGE);
            response.setStatus(Constants.SUCCESS);
            log.info("Successfully saved Items into cart");
        }
        catch(Exception e){
            log.error(Constants.SERVER_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
            throw new CartItemException(Constants.SERVER_MESSAGE,e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @Override
    public ProductInfoResponse getAllCartItems() throws CartItemException {
        try {
            List<ItemDto> itemDtos = StreamSupport.
                    stream(itemRepository.findAll().spliterator(), false).
                            map(ItemDto::new).collect(Collectors.toList());

            ProductInfoResponse productInfoDto = ProductInfoResponse.builder().
                    itemDtos(itemDtos).
                    message(Constants.CART_MESSAGE).
                    status(Constants.SUCCESS).build();
            log.info("Fetched data successfully from the database");
            return productInfoDto;
        }
        catch (Exception e){
            log.error(Constants.SERVER_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
            throw new CartItemException(Constants.SERVER_MESSAGE,e,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public CartResponse removeCartResponse(RemoveCartDto dto) throws CartItemException {
        CartResponse response = new CartResponse();
        try{
            if(dto.getAction().equals("empty_cart")){
                itemRepository.deleteAll();
                response.setMessage(Constants.REMOVE_CART_MESSAGE);
                response.setStatus(Constants.SUCCESS);
                log.info("Successfully deleted cart items !");
            }
            else{
                throw new CartItemException(Constants.BAD_REQUEST);
            }
        }
        catch(CartItemException e){
            log.error(e.getMessage(), HttpStatus.BAD_REQUEST);
            throw new CartItemException(e.getMessage(),e,HttpStatus.BAD_REQUEST);
        }
        catch(Exception e){
            log.error(Constants.SERVER_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
            throw new CartItemException(Constants.SERVER_MESSAGE,e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @Override
    public CartResponse checkoutTotalProductValue(long postalCode) throws CartItemException {

        CartResponse cartResponse = new CartResponse();
        try {
            WarehouseDto distanceDetails = service.getDistanceForDelhv_Address(postalCode).block();
            float price = 0F;
            List<ProductDto> productList = new ArrayList<>();
            List<ItemDto> itemDtos = StreamSupport.
                    stream(itemRepository.findAll().spliterator(), false).
                    map(ItemDto::new).collect(Collectors.toList());
            for(ItemDto item :itemDtos){
                ProductResponse response = service.getProductDetails(item.getProductId()).block();
                price =   price + (response.getProductDto().getPrice() * item.getQuantity())- (response.getProductDto().getDiscountPercentage()/100);
                productList.add(response.getProductDto());
            }
            //calculate shipping charges
            double weightInKg = productList.stream().mapToInt(ProductDto::getWeightInGrams).sum() / 1000;
            System.out.println("weight in grams " +productList.stream().mapToInt(ProductDto::getWeightInGrams).sum());
            System.out.println("weight in kg " +weightInKg);
            double totalShippingCharges = mapper.getPrice(weightInKg, distanceDetails.getDistance());
            cartResponse.setStatus(Constants.SUCCESS);

            //Dollar conversion
            Locale usa = new Locale("en", "US");
            NumberFormat formatter = NumberFormat.getCurrencyInstance(usa);
            cartResponse.setMessage("Total value of your shopping cart is - " + (formatter.format(price + totalShippingCharges)));
        }
        catch (Exception e){
            log.error(Constants.SERVER_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
            throw new CartItemException(Constants.SERVER_MESSAGE,e,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return cartResponse;
    }

}
