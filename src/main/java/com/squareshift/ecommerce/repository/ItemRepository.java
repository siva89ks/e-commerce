package com.squareshift.ecommerce.repository;

import com.squareshift.ecommerce.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity,Long> {


}


