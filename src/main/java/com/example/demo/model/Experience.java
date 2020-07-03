package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Experience {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String title;
	
	private String department;
	
	private int yearCount;
	
	@ManyToOne(fetch =FetchType.LAZY)
	@JsonIgnore
	private Employee employee;
	
	
	public Experience() {
		super();
	}

	public Experience(int id, String title, String department, int yearCount) {
		super();
		this.id = id;
		this.title = title;
		this.department = department;
		this.yearCount = yearCount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getYearCount() {
		return yearCount;
	}

	public void setYearCount(int yearCount) {
		this.yearCount = yearCount;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Experience [id=" + id + ", title=" + title + ", department=" + department + ", yearCount=" + yearCount
				+ "]";
	}
	
	
	


}
