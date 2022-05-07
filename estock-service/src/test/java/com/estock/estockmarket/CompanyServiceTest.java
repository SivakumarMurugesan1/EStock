package com.estock.estockmarket;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.estock.estockmarket.entity.Company;
import com.estock.estockmarket.repository.CompanyRepository;
import com.estock.estockmarket.service.CompanyService;

import lombok.SneakyThrows;

class CompanyServiceTest {
    
	 @InjectMocks
	    CompanyService companyservice;

	    @Mock
	    CompanyRepository companyrepository;

	    @BeforeEach
	    public void init() {
	        MockitoAnnotations.openMocks(this);
	    }

	
	@SneakyThrows
	@Test
	void registerNewCompanyTest() {
		Company company=new Company();
		company.setCompanyCeo("Rahul");
		company.setCompanyCode("Comp005");
		company.setCompanyName("ABC Corp");
		company.setCompanyTurnover(11.0);
		company.setCompanyWebsite("www.stock.com");
		company.setStockExchange("BSE");
		companyservice.registerCompany(company);
		verify(companyrepository, times(1)).save(company);
	}
	
	  @SneakyThrows
	  @Test
	    void getCompanyByCompanyCodeTest() {
	        when(companyrepository.findByCompanyCode("Comp005")).thenReturn(
	                (new Company("Comp005", "ABC Corp", "Rahul",20.0, "www.stock.com", "BSE")));
	                

	        Company newCompany = companyservice.getCompanyDetailsByCode("Comp005");

	        assertNotNull(newCompany);
	        assertEquals("ABC Corp", newCompany.getCompanyName());
	    }
	  
	   @Test
		public void getAllCompaniesTest()
		{
			List<Company> list = new ArrayList<Company>();
			Company companyOne = new Company("Comp005", "ABC Corp", "Rahul",20.0, "www.abc.com", "BSE");
			Company companyTwo = new Company("Comp006", "XYZ Corp", "Arun",30.0, "www.xyz.com", "BSE");
			Company companyThree = new Company("Comp007", "DEF Corp", "Raj",40.0, "www.def.com", "BSE");

			list.add(companyOne);
			list.add(companyTwo);
			list.add(companyThree);

			when(companyrepository.findAll()).thenReturn(list);

			List<Company> companyList = companyservice.getAllCompanyDetails();

			assertEquals(3, companyList.size());
			verify(companyrepository, times(1)).findAll();
		}
	  
	  

}
