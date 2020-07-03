package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> get() {
		// TODO Auto-generated method stub
		Session curSession=entityManager.unwrap(Session.class);
		Query<Employee> query=curSession.createQuery("from Employee",Employee.class);
		List<Employee> listOfEmployees=query.getResultList();
		return listOfEmployees;
	}

	@Override
	public Employee get(int id) {
		// TODO Auto-generated method stub
		Session curSession=entityManager.unwrap(Session.class);
		Employee employee=curSession.get(Employee.class, id);
		return employee;
	}

	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);	
		return employee;
	}

	@Override
	public Employee delete(int id) {
		// TODO Auto-generated method stub
		Session currentSession=entityManager.unwrap(Session.class);
		Employee employee=currentSession.get(Employee.class, id);
		currentSession.delete(employee);
		return employee;
	}

}
