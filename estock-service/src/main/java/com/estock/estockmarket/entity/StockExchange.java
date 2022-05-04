package com.estock.estockmarket.entity;

import java.time.LocalDateTime;


public class StockExchange {
	
	private Double price;
	private LocalDateTime stockAddedTm;
	
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public LocalDateTime getStockAddedTm() {
		return stockAddedTm;
	}
	public void setStockAddedTm(LocalDateTime stockAddedTm) {
		this.stockAddedTm = stockAddedTm;
	}
	
	
		  
}
