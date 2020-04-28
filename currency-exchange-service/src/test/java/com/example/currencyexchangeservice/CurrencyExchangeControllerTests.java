package com.example.currencyexchangeservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CurrencyExchangeControllerTests {

	@InjectMocks
	CurrencyExchangeController controller;
	
	@Test
	public void givenRequestWhenInvokeThenShouldReturnValues() {
		assertThat(controller).isNotNull();
		
		//given
		String to = "EUR";
		String from = "USD";
		
		//when
		ExchangeValue retrieveExchangeValue = controller.retrieveExchangeValue(from, to);
		
		//then
		assertNotNull(retrieveExchangeValue);
		assertEquals(from, retrieveExchangeValue.getFrom());
		assertEquals(to, retrieveExchangeValue.getTo());
	}

}
