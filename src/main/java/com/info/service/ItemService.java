package com.info.service;

import java.util.List;
import java.util.Optional;

import com.info.model.Item;


public interface ItemService {

	public void addItem(Item item);

	public List<Item> listItem();
	
	public Optional<Item> getItemById(long itemId);
	
	public List<Item> findByRegion(long regionId);
	
	public void deleteItem(long itemId);

}