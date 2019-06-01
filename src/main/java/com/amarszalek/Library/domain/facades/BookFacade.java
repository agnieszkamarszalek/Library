package com.amarszalek.Library.domain.facades;

import com.amarszalek.Library.domain.models.Book;
import com.amarszalek.Library.domain.repositories.BookRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookFacade {
    private BookRepository bookRepository;

    public Book getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn).orElseThrow(
                () -> new BookNotFoundException("Book not found by isbn: " + isbn)
        );
    }
}
