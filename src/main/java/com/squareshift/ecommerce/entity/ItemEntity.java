package com.squareshift.ecommerce.entity;

import javax.persistence.*;

@Entity
@Table(name = "Item")
public class ItemEntity implements BaseEntity {

    @Id
    private long productId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "description")
    private String description;

    public ItemEntity(long productId, int quantity, String description) {
        this.productId = productId;
        this.quantity = quantity;
        this.description = description;
    }

    public ItemEntity() {

    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
