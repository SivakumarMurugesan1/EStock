package com.stock.stockprice.entity;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDetails implements Serializable{

	private static final long serialVersionUID = 2397819372598672089L;
	
	private List<Stock> stockData;
	private Double minPrice;
	private Double maxPrice;
	private Double avgPrice;
}
