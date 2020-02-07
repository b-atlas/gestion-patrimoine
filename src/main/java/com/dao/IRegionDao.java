package com.dao;

import java.util.List;

import com.entities.Region;

public interface IRegionDao {
	
	public void saveRegion(Region region);
	
	public Region getRegion(int id);
	
	public Region deleteRegion(int id);
	
	public List<Region> getAllRegions();
}
