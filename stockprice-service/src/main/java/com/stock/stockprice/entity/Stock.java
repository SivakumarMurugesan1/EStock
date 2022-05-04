package com.stock.stockprice.entity;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection="Stock")
public class Stock {
	
	private String companyCode;
	private Double price;
	private LocalDateTime addedTm;
}
