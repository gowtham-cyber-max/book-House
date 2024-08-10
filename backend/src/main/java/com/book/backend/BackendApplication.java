package com.book.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@EnableMongoRepositories(basePackages = "com.book.backend")
@SpringBootApplication(scanBasePackages = {"com.book.backend"},exclude = {DataSourceAutoConfiguration.class})
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
