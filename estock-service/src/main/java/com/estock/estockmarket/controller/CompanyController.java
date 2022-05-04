package com.estock.estockmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estock.estockmarket.entity.Company;
import com.estock.estockmarket.entity.StockExchange;
import com.estock.estockmarket.exception.CompanyNotCreatedException;
import com.estock.estockmarket.exception.CompanyNotFoundException;
import com.estock.estockmarket.service.CompanyService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping(value = "/api/v1.0/market/company")
public class CompanyController {

	@Autowired
	CompanyService companyservice;


	/*
	 * @ApiOperation(value="Register new company",tags={"Register new company"},
	 * response=Long.class)
	 * 
	 * @ApiResponses(value= {@ApiResponse(code=200, message="Success"),
	 * 
	 * @ApiResponse(code=404, message="No Data Found"),
	 * 
	 * @ApiResponse(code=500, message="System Exception"),
	 * 
	 * @ApiResponse(code=500, message="Database Interaction Error"), })
	 */
	@PostMapping(value = "/register")
	public ResponseEntity<String> registerNewCompany(@RequestBody Company newCompany) throws CompanyNotCreatedException {
		String registercompany = null;
		
//			ValidateCompany validatecompany = new ValidateCompany();
//			validatecompany.companyValidation(newCompany);
			registercompany = companyservice.saveOrUpdate(newCompany);			
			return new ResponseEntity<String>(registercompany, HttpStatus.OK);
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
	  
	  
	  @GetMapping(value = "/stock/get/{companyCode}/{startdate}/{enddate}")
		public List<List<StockExchange>> getCompanyStockExchangeByStockDateRange(@PathVariable("companyCode")String companyCode,@PathVariable("startdate")String startdate,@PathVariable("enddate")String enddate) throws Exception{
			return companyservice.getStockseByDateRange(companyCode,startdate,enddate);
		}
	  

}
