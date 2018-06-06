package com.udea.MSproyecto;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages="com.udea.MSproyecto")

@EnableJpaRepositories(basePackages = { "com.udea.MSproyecto.dao" })
@EnableTransactionManagement

public class Application {	
	static final Logger log = Logger.getLogger(Application.class);

	// para correc con maven: mvn spring-boot:run
	public static void main(String[] args) {

		// PropertiesConfigurator is used to configure logger from properties
		// file
		PropertyConfigurator.configure("log4j.properties");

		// These logs will be sent to socket server as configured in log4j.xml
		log.info("Log4j socket appender test run successfully!!");

		SpringApplication.run(Application.class, args);

	}
}
