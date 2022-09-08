package com.info.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.info.model.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long>{
}
