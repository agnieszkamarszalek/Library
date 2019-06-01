package com.amarszalek.Library.domain.services;

import com.amarszalek.Library.domain.models.Book;
import com.amarszalek.Library.domain.repositories.BookRepository;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class BookService {

    private BookRepository bookRepository;

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
}
