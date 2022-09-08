package com.info.service;

import java.util.List;
import java.util.Optional;

import com.info.model.Provider;

public interface ProviderService {
	
	public void addProvider(Provider provider);
	
	public List<Provider> listProvider();
	
	public void deleteProvider(long providerId);
	
	public void updateProvider(Provider provider);
	
	public Optional<Provider> getProvider(long providerId);
	
}
