package com.dao.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.IRegionDao;
import com.entities.Region;

@Repository
public class RegionDaoImp implements IRegionDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveRegion(Region region) {

		// create session
		Session session = sessionFactory.getCurrentSession();
		
		// persist the object
		session.saveOrUpdate(region);
	}

	public Region getRegion(int id) {

		// create session
		Session session = sessionFactory.getCurrentSession();

		// get the object
		return session.get(Region.class, id);
	}

	public Region deleteRegion(int id) {

		// create session
		Session session = sessionFactory.getCurrentSession();

		// get the object
		Region region = getRegion(id);

		// delete the object
		if (region != null) {
			session.delete(region);
		}

		// return the deleted object
		return region;
	}

	public List<Region> getAllRegions() {
		
		// create session
		Session session = sessionFactory.getCurrentSession();

		// create query
		Query<Region> query = session.createQuery("from Region", Region.class);
		
		// execute query
		List<Region> regions = query.getResultList();
		
		// return the list
		return regions;
	}

}
