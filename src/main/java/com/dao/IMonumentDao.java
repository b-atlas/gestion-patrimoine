package com.dao;

import com.entities.Monument;

public interface IMonumentDao {
	
	public void saveMonument(Monument monument);
	
	public Monument getMonument(int id);
	
	public Monument deleteMonument(int id);
	
}
