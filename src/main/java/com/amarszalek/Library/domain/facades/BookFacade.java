package com.amarszalek.Library.domain.facades;

import com.amarszalek.Library.domain.models.Book;
import com.amarszalek.Library.domain.repositories.BookRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class BookFacade {
    private BookRepository bookRepository;

    public Book getBookByIsbnOrId(String isbn) {
        return bookRepository.findByIsbn(isbn).orElseGet(
                () -> bookRepository.findById(isbn).orElseThrow(
                        () ->  new BookNotFoundException("No results found")
                )
        );
    }

    public List<Book> getBooksByCategory(String categoryName) {
        return  bookRepository.findByCategories(categoryName)
                .orElseThrow(
                        () -> new BookNotFoundException("No results found")
                );
    }
}
