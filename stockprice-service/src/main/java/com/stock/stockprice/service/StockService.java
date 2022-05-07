package com.stock.stockprice.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.stock.stockprice.entity.Stock;
import com.stock.stockprice.entity.StockDetails;
import com.stock.stockprice.repository.StockRepository;

@Service
public class StockService {
	
	@Autowired
	StockRepository stockrepository;
	
	@Autowired
	MongoTemplate mongotemplate;

	
	  public String addCompanyNewStock(String companyCode,Stock stock) {
	    stock.setCompanyCode(companyCode);
	  //stock.setAddedTime(LocalDateTime.now());	      
         stockrepository.save(stock);
         return null;
	  }
	  
	  public StockDetails getStocksByDateRange(String companyCode,String startdate,String enddate) throws Exception{
			StockDetails stockdetails = new StockDetails();
			Criteria criteria = Criteria.where("addedTime").gte(convertStringDateToDateTime(startdate))
					.andOperator(Criteria.where("addedTime").lt(convertStringDateToDateTime(enddate)));

			if (StringUtils.isNotEmpty(companyCode)) {
				criteria = criteria.and("companyCode").is(companyCode);
			}
			Query query = new Query(criteria);
			List<Stock> stockList = mongotemplate.find(query, Stock.class);
			if (stockList.isEmpty())
				throw new NoSuchElementException();
			else {
				Optional<Stock> minStockPrice = stockList.stream().min(Comparator.comparing(Stock::getPrice));
				Optional<Stock> maxStockPrice = stockList.stream().max(Comparator.comparing(Stock::getPrice));
				double avg = stockList.stream().mapToDouble(stock -> stock.getPrice().doubleValue()).average()
						.getAsDouble();
				stockdetails.setAvgPrice(avg);
				if (minStockPrice.isPresent()) {
					stockdetails.setMinPrice(minStockPrice.get().getPrice());
				}
				if (maxStockPrice.isPresent()) {
					stockdetails.setMaxPrice(maxStockPrice.get().getPrice());
				}
			}
			stockdetails.setStockData(stockList);
			return stockdetails;
    }

	  private LocalDateTime convertStringDateToDateTime(String date) throws Exception {
		  try {                                                                  
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date,dateTimeFormatter);
        return localDate.atStartOfDay();
    } catch (Exception exception) {
        throw new Exception(exception.getMessage());
    }
}

}
