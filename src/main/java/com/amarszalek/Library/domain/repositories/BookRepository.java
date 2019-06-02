package com.amarszalek.Library.domain.repositories;

import com.amarszalek.Library.domain.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByIsbn(String isbn);
    Optional<List<Book>> findByCategoriesIgnoreCase(String category);
}
