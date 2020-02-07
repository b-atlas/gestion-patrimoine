package com.services.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IRegionDao;
import com.entities.Region;
import com.services.IRegionService;

@Service
public class RegionServiceImp implements IRegionService {
	
	@Autowired
	private IRegionDao regionDao;
	
	@Transactional
	public void saveRegion(Region region) {
		regionDao.saveRegion(region);
	}
	
	@Transactional
	public Region getRegion(int id) {
		return regionDao.getRegion(id);
	}
	
	@Transactional
	public Region deleteRegion(int id) {
		return regionDao.deleteRegion(id);
	}
	
	@Transactional
	public List<Region> getAllRegions() {
		return regionDao.getAllRegions();
	}

}
