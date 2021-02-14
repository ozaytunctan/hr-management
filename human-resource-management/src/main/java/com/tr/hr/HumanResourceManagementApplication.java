package com.tr.hr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.tr.hr.properties.ApplicationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = { ApplicationProperties.class })
@EnableAsync
@EnableScheduling
public class HumanResourceManagementApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(HumanResourceManagementApplication.class, args);
		
		
	}

}
