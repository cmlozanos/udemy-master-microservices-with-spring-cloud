package com.example.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimistConfigurationController {

	@Autowired
	Configuration configuration;
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfigurations() {
		return new LimitConfiguration(configuration.getMax(), configuration.getMin());
	}
	
	@GetMapping("/limits-fault-tolerance")
	@HystrixCommand(fallbackMethod = "retrieveLimitsFromConfigurationsFaultTolerance")
	public LimitConfiguration retrieveLimitsFromConfigurationsFailed() {
		throw new RuntimeException("Not available");
	}
	
	public LimitConfiguration retrieveLimitsFromConfigurationsFaultTolerance() {
		return new LimitConfiguration(9, 999);
	}
}
