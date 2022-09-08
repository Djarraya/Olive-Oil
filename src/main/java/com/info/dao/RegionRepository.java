package com.info.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.info.model.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long>{
}
