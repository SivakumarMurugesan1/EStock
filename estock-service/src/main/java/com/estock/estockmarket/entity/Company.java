package com.estock.estockmarket.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="Company")
public class Company {
	
	@Indexed(unique = true)
	private String companyCode;
	private String companyName;
	private String companyCeo;
	private Double companyTurnover;
	private String companyWebsite;
	private String stockExchange;
	
}
