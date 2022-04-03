package com.squareshift.ecommerce.adapter;


import com.squareshift.ecommerce.entity.BaseEntity;
import com.squareshift.ecommerce.Dto.BaseDto;

public interface BaseAdapter<T extends BaseDto ,E extends BaseEntity> {

     E saveEntity(T t);

}
