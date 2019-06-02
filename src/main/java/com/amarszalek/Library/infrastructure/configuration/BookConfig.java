package com.amarszalek.Library.infrastructure.configuration;

import com.amarszalek.Library.domain.facades.AuthorRatingFacade;
import com.amarszalek.Library.domain.facades.BookFacade;
import com.amarszalek.Library.domain.repositories.BookRepository;
import com.amarszalek.Library.domain.services.AuthorRatingService;
import com.amarszalek.Library.domain.services.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

    @Bean
    BookFacade bookFacade(ModelMapper modelMapper, BookService bookService) {
        return new BookFacade(modelMapper, bookService);
    }

    @Bean
    BookService bookService(BookRepository bookRepository) {
        return new BookService(bookRepository);
    }

    @Bean
    AuthorRatingService authorRating(BookService bookService) {
        return new AuthorRatingService(bookService);
    }

    @Bean
    AuthorRatingFacade authorRatingFacade(AuthorRatingService authorRatingService) {
        return new AuthorRatingFacade(authorRatingService);
    }
}
