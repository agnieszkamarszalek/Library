package com.amarszalek.Library.api.controllers;

import com.amarszalek.Library.domain.facades.AuthorRatingFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/rating")
public class AuthorsRatingsController {

    private AuthorRatingFacade authorRatingFacade;

    @GetMapping
    public ResponseEntity getAuthorsRating() {
        return new ResponseEntity(authorRatingFacade.getAverageRatingAllAuthors(), HttpStatus.OK);
    }
}
