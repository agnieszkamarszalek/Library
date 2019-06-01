package com.amarszalek.Library.api.controllers;

import com.amarszalek.Library.domain.facades.BookFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/book")
public class BookController {

    private BookFacade bookFacade;

    @GetMapping("/{isbn}")
    public ResponseEntity getBook(@PathVariable String isbn) {
        return new ResponseEntity(bookFacade.getBookByIsbn(isbn), HttpStatus.OK);
    }
}
