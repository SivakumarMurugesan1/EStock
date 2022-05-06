package com.estock.estockmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.estock.estockmarket.entity.Company;
import com.estock.estockmarket.exception.CompanyNotCreatedException;
import com.estock.estockmarket.exception.CompanyNotFoundException;
import com.estock.estockmarket.repository.CompanyRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository companyrepository;
	
	public String saveOrUpdate(Company newCompany) throws CompanyNotCreatedException{
		try {
			if(newCompany.getCompanyTurnover()<10)
				throw new Exception();
			 companyrepository.save(newCompany);
						
		} catch(Exception exception) {
			throw new CompanyNotCreatedException(exception.getMessage());
			}
		return null;
	}
	
	
	  public Company getCompanyDetailsByCode(String companyCode) throws CompanyNotFoundException{ 
		  try {
		   if(companyrepository.findByCompanyCode(companyCode)==null)			   
			   throw new Exception();
		   return companyrepository.findByCompanyCode(companyCode);
		  }catch(Exception e) {
			  throw new CompanyNotFoundException(e.getMessage());
		  }
		   

	  }
	  
	  public List<Company> getAllCompanyDetails(){
		  return companyrepository.findAll();
	  }
	 
	  public String deleteCompanyByCode(String companyCode) throws CompanyNotFoundException{
		  try {
			   if(companyrepository.findByCompanyCode(companyCode)==null)
				   throw new Exception();
			    companyrepository.deleteByCompanyCode(companyCode);
			  }
			 catch(Exception exception) {
					throw new CompanyNotFoundException(exception.getMessage());
				}
		  return null;
		  }
	  
	  
	 
	 
}
