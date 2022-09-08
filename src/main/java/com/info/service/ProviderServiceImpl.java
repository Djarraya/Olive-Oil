package com.info.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.dao.ProviderRepository;
import com.info.model.Provider;

@Service
@Transactional
public class ProviderServiceImpl implements ProviderService{

	@Autowired
	private ProviderRepository providerRepository;
	
	@Override
	public void addProvider(Provider provider) {
		providerRepository.save(provider);
	}

	@Override
	public List<Provider> listProvider() {
		return providerRepository.findAll();
	}

	@Override
	public void deleteProvider(long providerId) {
		providerRepository.deleteById(providerId);
	}

	@Override
	public void updateProvider(Provider provider) {
		providerRepository.save(provider);
	}

	@Override
	public Optional<Provider> getProvider(long providerId) {
		return providerRepository.findById(providerId);
	}

}
