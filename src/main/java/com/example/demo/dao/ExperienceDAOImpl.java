package com.example.demo.dao;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Experience;

@Repository
//because its interacting with the database
public class ExperienceDAOImpl implements ExperienceDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public Experience save(Experience ex) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(ex);
		return ex;
	}

}
