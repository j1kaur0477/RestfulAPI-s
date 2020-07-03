package com.example.demo.controller;

import java.lang.annotation.Annotation;
import java.net.URI;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resource.AuthenticationType;
import javax.management.RuntimeErrorException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.Experience;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.ExperienceService;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
@RestController
@RequestMapping("api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ExperienceService experienceService;
	
	@RequestMapping("/employee")
	@ResponseBody
	public List<Employee> get(){
		return employeeService.get();
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Object> save(@Validated @RequestBody Employee employee) {
		Employee emp=  employeeService.save(employee);
		
		//returning exact response code along with location of created resource
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(emp.getId()).toUri();
		return  ResponseEntity.created(location).build();

	}
	
//HateOs is Currently commented because of its dependency issues with swagger acuator 
	
//	@GetMapping("/employee/{id}")
//	
//	public EntityModel<Employee> get(@PathVariable int id) {
//		Employee employee=employeeService.get(id);
//		
//		
//		
//		if(employee==null) {
//			//throwing user defined exception
//			throw new EmployeeNotFoundException("Employee  with id "+id+"not found");
//		}
//		
//		//all users- add link below the single user= /server_path+/users
//		//Hateoasc
////		Link link = linkTo(methodOn(this.getClass()).get()).withRel("all-users");
////		System.out.println(link+"------------------");
////		EntityModel<Employee> resourceUser= new EntityModel(employee, link);
////		return resourceUser;
//	}
	
	@DeleteMapping("/employee/{id}")
	public void delete(@PathVariable int id) {
		
		Employee emp=employeeService.get(id);
		
		if(emp==null) {
			throw new EmployeeNotFoundException("Employee  with id "+id+"not found");
		}else {
			employeeService.delete(id);
		}
	}
	
	@PutMapping("/employee")
	public Employee update(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}
	
	
	//get user's posts using Id
	@GetMapping("/employee/{id}/experiences")
	public List<Experience> getPostsUserwise(@PathVariable int id) {
		Employee employee=employeeService.get(id);
		if(employee==null) {
			throw new EmployeeNotFoundException("Employee with id" +id +" not found");
		}
		 return employee.getExperiences();		
	}
	
	@PostMapping("/employee/{id}/experiences")
	public ResponseEntity<Object> save(@PathVariable int id,@RequestBody Experience experience) {
		Employee employee=  employeeService.get(id);
		if(employee==null) {
			throw new EmployeeNotFoundException("Employee with id " +id +" not found");
		}
		experience.setEmployee(employee);
		Experience ex=experienceService.save(experience);
		//returning exact response code along with location of created resource
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(experience.getId()).toUri();
		return  ResponseEntity.created(location).build();

	}
}
