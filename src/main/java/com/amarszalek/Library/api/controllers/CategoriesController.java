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
@RequestMapping("/api/category")
public class CategoriesController {

    private BookFacade bookFacade;

    @GetMapping("/{categoryName}/books")
    public ResponseEntity getBooksByCategory(@PathVariable String categoryName) {
        return new ResponseEntity(bookFacade.getBooksByCategory(categoryName), HttpStatus.OK);
    }
}
