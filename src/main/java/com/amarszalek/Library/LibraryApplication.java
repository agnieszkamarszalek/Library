package com.amarszalek.Library;

import com.amarszalek.Library.infrastructure.utils.JsonParseAndSaveToDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApplication {
    @Autowired
    private JsonParseAndSaveToDatabase jsonParseAndSaveToDatabase;

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
            jsonParseAndSaveToDatabase.parseAndSave();
		};
	}

}
