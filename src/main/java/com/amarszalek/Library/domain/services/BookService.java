package com.amarszalek.Library.domain.services;

import com.amarszalek.Library.domain.exceptions.BookNotFoundException;
import com.amarszalek.Library.domain.models.Book;
import com.amarszalek.Library.domain.repositories.BookRepository;
import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class BookService {

    private BookRepository bookRepository;

    public List<Book> getBooksByPhrase(String phrase) {
        List<Book> booksWithPhrase = new ArrayList<>();
        List<Book> books = bookRepository.findAll();
        String lowerCasePhrase = phrase.toLowerCase();
        for (Book book : books ) {
            if (book.getTitle() != null && book.getTitle().toLowerCase().contains(lowerCasePhrase)) {
                booksWithPhrase.add(book);
                continue;
            }
            if (book.getSubtitle() != null && book.getSubtitle().toLowerCase().contains(lowerCasePhrase)) {
                booksWithPhrase.add(book);
                continue;
            }
            if (book.getPublisher()!= null && book.getPublisher().toLowerCase().contains(lowerCasePhrase)) {
                booksWithPhrase.add(book);
                continue;
            }
            if (book.getDescription() != null && book.getDescription().toLowerCase().contains(lowerCasePhrase)) {
                booksWithPhrase.add(book);
                continue;
            }
            for (String categories : book.getCategories()) {
                if(categories.toLowerCase().contains(lowerCasePhrase)) {
                    booksWithPhrase.add(book);
                    break;
                }
            }
            for (String author : book.getAuthors()) {
                if(author.toLowerCase().contains(lowerCasePhrase)) {
                    booksWithPhrase.add(book);
                    break;
                }
            }
        }
        return booksWithPhrase;
    }

    Map<String, List<Double>> getAuthorsWithTheirsBooksRatings() {
        List<Book> allBooks = bookRepository.findAll();
        Map<String, List<Double>> authorsAndBooksRatingMap = new HashMap<>();
        for (Book book : allBooks) {
            if (book.getAverageRating() == null) {
                continue;
            }
            for (String author : book.getAuthors()) {
                List<Double> ratingsList = authorsAndBooksRatingMap.getOrDefault(author, new ArrayList<Double>());
                ratingsList.add(book.getAverageRating());
                authorsAndBooksRatingMap.put(author, ratingsList);
            }
        }
        return authorsAndBooksRatingMap;
    }

    public List<Book> getBooksByCategory(String categoryName) {
        return bookRepository.findByCategoriesIgnoreCase(categoryName)
                .orElse(new ArrayList<>());
    }

    public Book findByIsbn(String isbn) {
        return  bookRepository.findByIsbn(isbn).orElseThrow(
                        () -> new BookNotFoundException("No results found")
        );
    }
}
