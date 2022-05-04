package com.estock.estockmarket.repository;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.estock.estockmarket.entity.Company;
import com.estock.estockmarket.entity.StockExchange;

public interface CompanyRepository extends MongoRepository<Company, Integer> {
	
	Company findByCompanyCode(String companyCode);
	Company deleteByCompanyCode(String companyCode);
	
	@Query("{stockAddedTm:{'$gt': ?0, '$lt':?1} }")
	List<List<StockExchange>> findByCompanyCodeByStockAddedTmBetween(LocalDateTime startdate,LocalDateTime enddate);
		
}
