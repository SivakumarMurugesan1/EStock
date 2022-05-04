package com.stock.stockprice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stock.stockprice.entity.Stock;

public interface StockRepository extends MongoRepository<Stock, Integer>{

}
