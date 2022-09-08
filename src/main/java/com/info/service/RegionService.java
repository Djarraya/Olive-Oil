package com.info.service;

import java.util.List;
import java.util.Optional;

import com.info.model.Region;

public interface RegionService {
	
	public void addRegion(Region region);
	
	public List<Region> listRegion();
	
	public void deleteRegion(long regionId);
	
	public void updateRegion(Region region);
	
	public Optional<Region> getRegion(long regionId);
	
}
