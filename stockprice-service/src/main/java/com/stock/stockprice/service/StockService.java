package com.stock.stockprice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.stockprice.entity.Stock;
import com.stock.stockprice.repository.StockRepository;

@Service
public class StockService {
	
	@Autowired
	StockRepository stockrepository;
	
	  public String addExistingCompanyNewStock(String companyCode,Stock stock) {
		  System.out.println("companycode"+companyCode+"stock"+stock.toString());
	  stock.setCompanyCode(companyCode);
      stockrepository.save(stock);
           return null;
	  }

}
