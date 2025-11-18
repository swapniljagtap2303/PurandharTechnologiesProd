package com.purandhar.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = "com.purandhar.website")
@EntityScan(basePackages = "com.purandhar.website.model")
public class PurandharWebsiteBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PurandharWebsiteBackendApplication.class, args);
	}

}
