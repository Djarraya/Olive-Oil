package com.info.service;

import java.util.List;
import java.util.Optional;

import com.info.model.Product;

public interface ProductService {

	public void addProduct(Product product);
	
	public void delProduct(Product product);

	public List<Product> listProduct();
	
	public Optional<Product> getProductById(long productId);
	
	public List<Product> findByCategory(long categoryId);
	
	
	public List<Product> findByProvider(long providerId);
	
	
	
	public void deleteProduct(long productId);

}
