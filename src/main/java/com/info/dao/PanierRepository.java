package com.info.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.info.model.Panier;

@Repository
public interface PanierRepository extends JpaRepository<Panier, Long>{
	
	public List<Panier> findByProduct_ProductId(long ProductId);
	public List<Panier> findByUser_UserId(long UserId);
	
}
