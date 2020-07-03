package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ExperienceDAO;
import com.example.demo.model.Experience;

@Service
public class ExperienceServiceImpl implements ExperienceService{

	@Autowired
	private ExperienceDAO experienceDAO;
	
	@Transactional
	@Override
	public Experience save(Experience ex) {
		return experienceDAO.save(ex);
	}

}
