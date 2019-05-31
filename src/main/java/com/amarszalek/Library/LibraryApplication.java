package com.amarszalek.Library;

import com.amarszalek.Library.infrastructure.utils.jsonParse.JsonParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			JsonParser jsonParser = new JsonParser();
			jsonParser.parseToBook();
		};
	}

}
