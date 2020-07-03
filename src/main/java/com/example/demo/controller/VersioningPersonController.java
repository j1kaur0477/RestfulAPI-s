package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Name;
import com.example.demo.model.PersonVersion1;
import com.example.demo.model.PersonVersion2;

@RequestMapping("version")
@RestController
public class VersioningPersonController {
	
	//API versioning means maintaining multiple versions of API at same time
	//URI versioning
	//1- way is URI (make different URI for multiple versions
	@GetMapping("/v1/person")
	public PersonVersion1 personV1() {
		return new PersonVersion1("Jaspreet Kaur");
	}
	
	@GetMapping("/v2/person")
	public PersonVersion2 personV2() {
		return new PersonVersion2(new Name("Jaspreet ","Kaur"));
	}
	
	//Request Param Versioning
	//2- way is passing param (pass different parameter values for different versions
	@GetMapping(path = "/person/param",params = "version=1")
	public PersonVersion1 paramV1() {
		return new PersonVersion1("Jaspreet Kaur");
	}
	
	@GetMapping(path = "/person",params = "version=2")
	public PersonVersion2 paramV2() {
		return new PersonVersion2(new Name("Jaspreet ","Kaur"));
	}
	
	//Header Param Versioning
	//3-passing parameter in request header
	@GetMapping(path = "/person",headers = "X-API-VERSION=1")
	public PersonVersion1 headerV1() {
		return new PersonVersion1("Jaspreet Kaur");
	}
	
	@GetMapping(path = "/person",headers = "X-API-VERSION=2")
	public PersonVersion2 headerV2() {
		return new PersonVersion2(new Name("Jaspreet ","Kaur"));
	}

	//Media Type Versioning
	//4- by using produces in request header
	@GetMapping(path = "/person",produces = "application/jk-v1+json")
	public PersonVersion1 producesV1() {
		return new PersonVersion1("Jaspreet Kaur");
	}
	
	@GetMapping(path = "/person",produces = "application/jk-v2+json")
	public PersonVersion2 producesV2() {
		return new PersonVersion2(new Name("Jaspreet ","Kaur"));
	}

}
