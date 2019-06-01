package com.amarszalek.Library.domain.facades;

import com.amarszalek.Library.domain.exceptions.BookNotFoundException;
import com.amarszalek.Library.domain.models.Book;
import com.amarszalek.Library.domain.repositories.BookRepository;
import com.amarszalek.Library.domain.services.BookService;
import com.amarszalek.Library.infrastructure.dtos.BookDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BookFacade {
    private BookRepository bookRepository;
    private ModelMapper modelMapper;
    private BookService bookService;

    public BookDto getBookByIsbnOrId(String isbn) {
        Book book = bookRepository.findByIsbn(isbn).orElseGet(
                () -> bookRepository.findById(isbn).orElseThrow(
                        () -> new BookNotFoundException("No results found")
                )
        );
        return modelMapper.map(book, BookDto.class);
    }

    public List<BookDto> getBooksByCategory(String categoryName) {
        List<Book> books = bookRepository.findByCategoriesIgnoreCase(categoryName)
                .orElseThrow(
                        () -> new BookNotFoundException("No results found")
                );
        return mapBookListToBookDtoList(books);
    }

    public List<BookDto> findByPhrase(String phrase) {
        List<Book> booksByPhrase = bookService.getBooksByPhrase(phrase);
        return mapBookListToBookDtoList(booksByPhrase);
    }

    private List<BookDto> mapBookListToBookDtoList(List<Book> books) {
        return books.stream()
                .map(book -> modelMapper.map(book, BookDto.class))
                .collect(Collectors.toList());
    }
}
