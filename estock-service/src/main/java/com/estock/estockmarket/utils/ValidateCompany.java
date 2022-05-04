package com.estock.estockmarket.utils;

import org.apache.commons.lang.StringUtils;

import com.estock.estockmarket.entity.Company;

public class ValidateCompany {
	
	public void companyValidation(Company company) throws Exception {
		if(company==null) {
			
			//throw exception 
		} else {
			
			  String companyName = company.getCompanyName(); 
			  String companyCeo = company.getCompanyCeo(); 
			  String companyWebsite = company.getCompanyWebsite();
			  String companyCode = company.getCompanyCode(); 
			  Double companyTurnOver =  company.getCompanyTurnover(); 
			  
			  if(StringUtils.isEmpty(companyName) || StringUtils.isEmpty(companyCeo) || StringUtils.isEmpty(companyWebsite) || StringUtils.isEmpty(companyCode) || companyTurnOver<10.00) {
			  System.out.println("not valid");
			  throw new Exception();
			}
	}

}
}
