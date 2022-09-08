package com.info.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.dao.PanierRepository;
import com.info.model.Panier;

@Service
@Transactional
public class PanierServiceImpl implements PanierService{
	
	@Autowired
	private PanierRepository panierRepository;

	@Override
	public void addPanier(Panier panier) {
		panierRepository.save(panier);
	}
	
	@Override
	public void delPanier(Panier panier) {
		panierRepository.delete(panier);
	}

	@Override
	public List<Panier> listPanier() {
		return panierRepository.findAll();
	}

	@Override
	public Optional<Panier> getPanierById(long panierId) {
		return panierRepository.findById(panierId);
	}

	@Override
	public List<Panier> findByProduct(long productId) {
		return panierRepository.findByProduct_ProductId(productId);
	}
	
	@Override
	public List<Panier> findByUser(long userId) {
		return panierRepository.findByUser_UserId(userId);
	}
	
	@Override
	public void deletePanier(long panierId) {
		panierRepository.deleteById(panierId);
	}

}
