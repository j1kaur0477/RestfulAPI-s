package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Transactional
	@Override
	public List<Employee> get() {
		// TODO Auto-generated method stub
		List<Employee> listOfEmployees=employeeDAO.get();
		return listOfEmployees;
	}
	
	@Transactional
	@Override
	public Employee get(int id) {
		// TODO Auto-generated method stub
		return employeeDAO.get(id);
	}

	@Transactional
	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		Employee emp=employeeDAO.save(employee);
		return emp;
	}

	@Transactional
	@Override
	public Employee delete(int id) {
		// TODO Auto-generated method stub
		Employee emp=employeeDAO.delete(id);
		return emp;
	}

}
