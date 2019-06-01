package com.amarszalek.Library.infrastructure.configuration;

import com.amarszalek.Library.domain.facades.BookFacade;
import com.amarszalek.Library.domain.repositories.BookRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

    @Bean
    BookFacade bookFacade(BookRepository bookRepository) {
        return new BookFacade(bookRepository);
    }
}