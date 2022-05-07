package com.stock.stockprice.entity;

import java.time.LocalDateTime;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"companyCode"})
@Document(collection="Stock")
public class Stock {
		
	@ApiModelProperty(hidden=true)
	private String companyCode;
	private Double price;
	private LocalDateTime addedTime;
	
	
}
