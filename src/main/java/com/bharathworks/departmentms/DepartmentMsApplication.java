package com.bharathworks.departmentms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DepartmentMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentMsApplication.class, args);
	}

}
