package com.dc.java.back.end.converter;

import java.util.stream.Collectors;

import com.dc.java.back.end.model.Item;
import com.dc.java.back.end.model.Shop;
import com.dc.java.back.end.dto.ItemDTO;
import com.dc.java.back.end.dto.ShopDTO;


public class DTOConverter {
	
	public static ItemDTO convert(Item item) {
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setProductIdentifier(item.getProductIdentifier());
		itemDTO.setPrice(item.getPrice());
		return itemDTO;
	}
	
	public static ShopDTO convert(Shop shop) {
		ShopDTO shopDTO = new ShopDTO();
		shopDTO.setUserIdentifier(shop.getUserIdentifier());
		shopDTO.setTotal(shop.getTotal());
		shopDTO.setDate(shop.getDate());
		shopDTO.setItems(shop.getItems().stream().map(DTOConverter::convert).collect(Collectors.toList()));
		return shopDTO;
	}	
	
}
