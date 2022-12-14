package com.info.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.info.model.Item;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
	
	public List<Item> findByRegion_RegionId(long RegionId);
	
	
}
