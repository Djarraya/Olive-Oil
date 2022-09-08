package com.info.service;

import java.util.List;
import java.util.Optional;

import com.info.model.Panier;

public interface PanierService {

	public void addPanier(Panier panier);
	
	public void delPanier(Panier panier);

	public List<Panier> listPanier();
	
	public Optional<Panier> getPanierById(long panierId);
	
	public List<Panier> findByUser(long userId);
	
	public List<Panier> findByProduct(long productId);
	
	public void deletePanier(long panierId);

}