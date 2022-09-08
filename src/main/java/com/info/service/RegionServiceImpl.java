package com.info.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.dao.RegionRepository;
import com.info.model.Region;

@Service
@Transactional
public class RegionServiceImpl implements RegionService{

	@Autowired
	private RegionRepository regionRepository;
	
	@Override
	public void addRegion(Region region) {
		regionRepository.save(region);
	}

	@Override
	public List<Region> listRegion() {
		return regionRepository.findAll();
	}

	@Override
	public void deleteRegion(long regionId) {
		regionRepository.deleteById(regionId);
	}

	@Override
	public void updateRegion(Region region) {
		regionRepository.save(region);
	}

	@Override
	public Optional<Region> getRegion(long regionId) {
		return regionRepository.findById(regionId);
	}

}
