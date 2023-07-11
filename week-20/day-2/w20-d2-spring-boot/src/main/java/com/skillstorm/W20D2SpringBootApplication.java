package com.skillstorm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class W20D2SpringBootApplication {
	
	// creating a Logger instance to use for our custom logs
	public static final Logger LOGGER = LoggerFactory.getLogger(W20D2SpringBootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(W20D2SpringBootApplication.class, args);
		
		// sending out an individual log message
		LOGGER.info("****** Test log *******");
	}

}
