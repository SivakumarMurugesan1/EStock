package com.estock.estockmarket.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.estock.estockmarket.entity.Company;


public interface CompanyRepository extends MongoRepository<Company, Integer> {
	
	Company findByCompanyCode(String companyCode);
	Company deleteByCompanyCode(String companyCode);
	
	
		
}
