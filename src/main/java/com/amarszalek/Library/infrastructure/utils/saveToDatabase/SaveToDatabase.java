package com.amarszalek.Library.infrastructure.utils.saveToDatabase;

import com.amarszalek.Library.domain.models.Book;
import com.amarszalek.Library.domain.repositories.BookRepository;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class SaveToDatabase {

    private BookRepository bookRepository;

    public void saveBooks(List<Book> bookList) {
        bookRepository.saveAll(bookList);
    }
}
