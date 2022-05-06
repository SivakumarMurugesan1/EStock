package com.stock.stockprice.entity;

import java.time.LocalDateTime;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties({"companyCode"})
@Document(collection="Stock")
public class Stock {
		
//	private List<StockDetails> stockData;
//	@Transient
//	@ApiModelProperty(hidden=true)
//	private Double minPrice;
//	@Transient
//	@ApiModelProperty(hidden=true)
//	private Double maxPrice;
//	@Transient
//	@ApiModelProperty(hidden=true)
//	private Double avgPrice;
	
	@ApiModelProperty(hidden=true)
	private String companyCode;
	private Double price;
	private LocalDateTime addedTime;
	
	
}
