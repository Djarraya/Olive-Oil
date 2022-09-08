package com.info.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.dao.ItemRepository;
import com.info.model.Item;


@Service
@Transactional
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public void addItem(Item item) {
		itemRepository.save(item);
	}

	@Override
	public List<Item> listItem() {
		return itemRepository.findAll();
	}

	@Override
	public Optional<Item> getItemById(long itemId) {
		return itemRepository.findById(itemId);
	}

	@Override
	public List<Item> findByRegion(long regionId) {
		return itemRepository.findByRegion_RegionId(regionId);
	}

	@Override
	public void deleteItem(long itemId) {
		itemRepository.deleteById(itemId);
	}

}