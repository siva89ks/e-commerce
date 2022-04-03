package com.squareshift.ecommerce.adapter;


import com.squareshift.ecommerce.entity.ItemEntity;
import com.squareshift.ecommerce.model.ItemDto;
import org.springframework.stereotype.Component;

@Component
public class ItemAdapter implements BaseAdapter<ItemDto, ItemEntity> {

    @Override
    public ItemEntity saveEntity(ItemDto itemDto){
        ItemEntity entity = new ItemEntity();
        entity.setProductId(itemDto.getProductId());
        entity.setDescription(itemDto.getDescription());
        entity.setQuantity(itemDto.getQuantity());
        return entity;
    }

}
