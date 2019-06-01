package com.amarszalek.Library.api.controllers;

import com.amarszalek.Library.domain.facades.BookFacade;
import com.amarszalek.Library.domain.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/search")
public class SearchController {

    private BookFacade bookFacade;

    @RequestMapping
    public ResponseEntity findByPhrase(@RequestParam("q") String phrase) {
        return new ResponseEntity(bookFacade.findByPhrase(phrase), HttpStatus.OK);
    }
}
