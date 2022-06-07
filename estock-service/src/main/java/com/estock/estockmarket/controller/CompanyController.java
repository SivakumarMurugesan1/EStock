package com.estock.estockmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estock.estockmarket.entity.Company;
import com.estock.estockmarket.exception.CompanyNotCreatedException;
import com.estock.estockmarket.exception.CompanyNotFoundException;
import com.estock.estockmarket.service.CompanyService;


@RestController
@RequestMapping(value = "/api/v1.0/market/company")
@CrossOrigin("*")
public class CompanyController {

	@Autowired
	CompanyService companyservice;

	@Autowired 
	KafkaTemplate<String,Company> kafkaTemplate;
	
	private static final String TOPIC_NAME="kafka_topic_name";

	@PostMapping(value = "/register")
	public ResponseEntity<String> registerNewCompany(@RequestBody Company newCompany) throws CompanyNotCreatedException {
			companyservice.registerCompany(newCompany);	
			kafkaTemplate.send(TOPIC_NAME, newCompany);
			return new ResponseEntity<String>(HttpStatus.OK);
	}

	
	  @GetMapping(value = "/info/{companyCode}") 
	  public Company getCompanyByCode(@PathVariable("companyCode") String companyCode) throws CompanyNotFoundException{ 
		    return companyservice.getCompanyDetailsByCode(companyCode);
	  }
	 
	  @GetMapping(value = "/getall") 
	  public List<Company> getAllCompanies(){ 
		  return companyservice.getAllCompanyDetails();
		  }
	  
	  @DeleteMapping(value = "/delete/{companyCode}") 
	  public ResponseEntity<String> deleteCompany(@PathVariable("companyCode") String companyCode) throws CompanyNotFoundException {
		  return new ResponseEntity<String>(companyservice.deleteCompanyByCode(companyCode), HttpStatus.OK);
	  }
	  
	  	  
	 
	  

}
