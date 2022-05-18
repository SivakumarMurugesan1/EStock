package com.stock.stockprice;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stock.stockprice.entity.Stock;
import com.stock.stockprice.repository.StockRepository;
import com.stock.stockprice.service.StockService;

import lombok.SneakyThrows;

class StockServiceTest {

	 @InjectMocks
	    StockService stockservice;

	    @Mock
	    StockRepository stockrepository;

	    @BeforeEach
	    public void init() {
	        MockitoAnnotations.openMocks(this);
	    }

	
	@SneakyThrows
	@Test
	void addCompanyStockTest() {
		Stock stock=new Stock();
		stock.setCompanyCode("Comp005");
		stock.setPrice(500.0);
		stock.setAddedTime(LocalDateTime.now());
		stockservice.addCompanyNewStock(stock.getCompanyCode(),stock);
		verify(stockrepository, times(1)).save(stock);
	}
	

}
