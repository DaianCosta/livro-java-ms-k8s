package com.dc.java.back.end.model;

import com.dc.java.back.end.dto.ItemDTO;

import javax.persistence.Embeddable;

@Embeddable
public class Item {

    private String productIdentifier;
    private Float price;

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String product) {
        this.productIdentifier = product;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public static Item convert(ItemDTO itemDTO) {
        Item item = new Item();
        item.setProductIdentifier(itemDTO.getProductIdentifier());
        item.setPrice(itemDTO.getPrice());
        return item;
    }

}
