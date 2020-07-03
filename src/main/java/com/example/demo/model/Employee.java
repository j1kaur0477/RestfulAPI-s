package com.example.demo.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Filter;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//hibernate
@Entity
@Table(name = "Employee")
//swagger documentation
@ApiModel(description = "Information about user")
//to filter properties statically
//@JsonIgnoreProperties(value= {"gender","dob"})

//to filter response dynamically 
//@JsonFilter(value = "AgeAndDOBFilterForListRequest")
public class Employee {
//	create table Employee(
//			id int not null primary key auto_increment,
//			name varchar(255),
//			gender varchar(255),
//			department varchar(255),
//			dob date);
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	@Size(max = 2)
	@ApiModelProperty(notes = "name cannot be les than 2 characters")
	private String name;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "department")
	private String department;
	
	@Past(message = "date cannot be in past")
	@Column(name = "dob")
	@ApiModelProperty(notes = "date cannot be in past")
	private Date dob;
	
	@OneToMany(mappedBy = "employee" )
	private List<Experience>  experiences;

	public Integer getId() {
		return id;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", department=" + department + ", dob="
				+ dob + ", getId()=" + getId() + ", getName()=" + getName() + ", getGender()=" + getGender()
				+ ", getDepartment()=" + getDepartment() + ", getDob()=" + getDob() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
	
}
