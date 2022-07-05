package com.hexaware.InsuranceClaimManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
public class InsuranceClaimManagementApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceClaimManagementApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(InsuranceClaimManagementApplication.class);
	}
}
