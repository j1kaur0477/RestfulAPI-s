package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping("filtering")
public class FilteringEmployeeController {
	
	//Static filtering for API
	//fields filtering from model class add annotations
	//1- on attribute @JsonIgnore
	//2- on class Level @JsonIgnoreProperties(value= {"gender","dob"})
	
	//Dynamic filtering for API
	//filtering different fields for different requests
	//Make use of MappingJacksonValue and filters

	
	@Autowired
	EmployeeService employeeService;
	
	//get list of employees after filtering
	@GetMapping("/employee")
	public MappingJacksonValue get(){
		List<Employee> empList=employeeService.get();
		
		//implementing Dynamic filtering
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("gender","dob");

		FilterProvider filters=new SimpleFilterProvider().addFilter("AgeAndDOBFilterForListRequest", filter);

		MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(empList);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
	
	//get single employee after filtering
	@GetMapping("/employee/{id}")
	public MappingJacksonValue getId(@PathVariable int id) {
		Employee emp=employeeService.get(id);
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("name","gender");
		FilterProvider filters=new SimpleFilterProvider().addFilter("AgeAndDOBFilterForListRequest", filter);
		MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(emp);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
	

}
