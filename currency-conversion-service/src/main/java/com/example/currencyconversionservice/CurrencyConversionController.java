package com.example.currencyconversionservice;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean converCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		return new CurrencyConversionBean(1000L, from, to, BigDecimal.ONE, quantity, BigDecimal.TEN, 8000);
	}

}
