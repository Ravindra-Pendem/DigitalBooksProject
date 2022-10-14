package com.readerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@EnableFeignClients
@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Reader Application",
				version = "1.1",
				description = "This app is used to get the reader data"
				)
		)
public class ReaderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReaderServiceApplication.class, args);
	}

}
