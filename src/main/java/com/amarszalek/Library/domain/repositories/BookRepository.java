package com.amarszalek.Library.domain.repositories;

import com.amarszalek.Library.domain.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
