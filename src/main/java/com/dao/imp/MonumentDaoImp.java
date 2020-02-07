package com.dao.imp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.IMonumentDao;
import com.entities.Monument;

@Repository
public class MonumentDaoImp implements IMonumentDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveMonument(Monument monument) {

		// create session
		Session session = sessionFactory.getCurrentSession();

		// persist the object
		session.saveOrUpdate(monument);

	}

	public Monument getMonument(int id) {

		// create session
		Session session = sessionFactory.getCurrentSession();

		// get the object
		return session.get(Monument.class, id);
	}

	public Monument deleteMonument(int id) {

		// create session
		Session session = sessionFactory.getCurrentSession();

		// get the object
		Monument monument = getMonument(id);

		// delete the object
		if (monument != null) {
			session.delete(monument);
		}

		// return the deleted object
		return monument;
	}

}
