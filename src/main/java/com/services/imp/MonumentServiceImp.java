package com.services.imp;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IMonumentDao;
import com.entities.Monument;
import com.services.IMonumentService;

@Service
public class MonumentServiceImp implements IMonumentService {
	
	@Autowired
	IMonumentDao monumentDao;
	
	@Transactional
	public void saveMonument(Monument monument) {
		monumentDao.saveMonument(monument);
	}
	
	@Transactional
	public Monument getMonument(int id) {
		return monumentDao.getMonument(id);
	}
	
	@Transactional
	public Monument deleteMonument(int id) {
		return monumentDao.deleteMonument(id);
	}

}
