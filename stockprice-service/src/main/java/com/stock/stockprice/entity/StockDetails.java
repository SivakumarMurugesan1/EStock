package com.stock.stockprice.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDetails{
	
	private List<Stock> stockData;
	private Double minPrice;
	private Double maxPrice;
	private Double avgPrice;
}
