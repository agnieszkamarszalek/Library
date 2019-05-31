package com.amarszalek.Library.domain.services;

import com.amarszalek.Library.domain.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {

    private BookRepository bookRepository;

}
