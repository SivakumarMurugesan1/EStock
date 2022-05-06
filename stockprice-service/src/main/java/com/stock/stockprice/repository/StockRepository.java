package com.stock.stockprice.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.stock.stockprice.entity.Stock;

public interface StockRepository extends MongoRepository<Stock, Integer>{
   
//	@Query("{'addedTime':{$gt: ?0, $lt:?1} }")
//	List<Stock> findByAddedTimeBetween(LocalDateTime startdate,LocalDateTime enddate);
	
}
