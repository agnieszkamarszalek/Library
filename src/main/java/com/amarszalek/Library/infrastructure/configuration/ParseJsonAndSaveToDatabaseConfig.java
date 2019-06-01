package com.amarszalek.Library.infrastructure.configuration;

import com.amarszalek.Library.domain.repositories.BookRepository;
import com.amarszalek.Library.infrastructure.utils.JsonParseAndSaveToDatabase;
import com.amarszalek.Library.infrastructure.utils.jsonParse.JsonParser;
import com.amarszalek.Library.infrastructure.utils.saveToDatabase.SaveToDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParseJsonAndSaveToDatabaseConfig {

    @Bean
    SaveToDatabase saveToDatabase(BookRepository bookRepository) {
        return new SaveToDatabase(bookRepository);
    }

    @Bean
    JsonParser jsonParser() {
        return new JsonParser();
    }

    @Bean
    JsonParseAndSaveToDatabase jsonParseAndSaveToDatabase(JsonParser jsonParser, SaveToDatabase saveToDatabase) {
        return new JsonParseAndSaveToDatabase(jsonParser, saveToDatabase);
    }
}
