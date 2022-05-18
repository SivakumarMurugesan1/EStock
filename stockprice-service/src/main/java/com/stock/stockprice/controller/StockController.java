package com.stock.stockprice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stock.stockprice.entity.Stock;
import com.stock.stockprice.entity.StockDetails;
import com.stock.stockprice.service.StockService;

@RestController
@RequestMapping(value = "/api/v1.0/market/stock")
public class StockController {

	@Autowired
	StockService stockservice;

	@PostMapping(value = "/add/{companyCode}")
	public ResponseEntity<String> addCompanyNewStock(@PathVariable String companyCode, @RequestBody Stock newStock) {
		stockservice.addCompanyNewStock(companyCode, newStock);
		return new ResponseEntity<>("Stock Added!", HttpStatus.OK);
	}

	@GetMapping(value = "/get/{companyCode}/{startdate}/{enddate}")
	public StockDetails getCompanyStockByDateRange(@PathVariable("companyCode") String companyCode,
			@PathVariable("startdate") String startdate, @PathVariable("enddate") String enddate) throws Exception {
		return stockservice.getStocksByDateRange(companyCode, startdate, enddate);
	}
}
