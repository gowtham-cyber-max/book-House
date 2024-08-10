package com.book.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@EnableMongoRepositories(basePackages = "com.book.spring")
@SpringBootApplication(scanBasePackages = {"com.book.spring"},exclude = {DataSourceAutoConfiguration.class})

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
