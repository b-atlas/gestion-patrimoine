package com.services;

import com.entities.Monument;

public interface IMonumentService {

	public void saveMonument(Monument monument);

	public Monument getMonument(int id);

	public Monument deleteMonument(int id);

}
