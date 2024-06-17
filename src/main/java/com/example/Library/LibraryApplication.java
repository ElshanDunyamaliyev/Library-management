package com.example.Library;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Library application REST API Documentation",
				description = "Library application for REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Elshan Dunyamaliyev",
						email = "elshandunyamaliyev@gmail.com"
				)
		)
)
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

}
