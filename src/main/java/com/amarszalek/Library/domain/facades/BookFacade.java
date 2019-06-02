package com.amarszalek.Library.domain.facades;

import com.amarszalek.Library.domain.models.Book;
import com.amarszalek.Library.domain.services.BookService;
import com.amarszalek.Library.infrastructure.dtos.BookDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BookFacade {
    private ModelMapper modelMapper;
    private BookService bookService;

    public BookDto getBookByIsbnOrId(String isbn) {
        Book book = bookService.findByIsbn(isbn);
        return modelMapper.map(book, BookDto.class);
    }

    public List<BookDto> getBooksByCategory(String categoryName) {
        List<Book> books = bookService.getBooksByCategory(categoryName);
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
