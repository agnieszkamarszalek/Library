package com.amarszalek.Library.domain.facades;

import com.amarszalek.Library.domain.services.AuthorRating;
import com.amarszalek.Library.infrastructure.dtos.AuthorRatingDto;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AuthorRatingFacade {

    private AuthorRating authorRating;

    public List<AuthorRatingDto> getAverageRatingAllAuthors() {
        Map<String, Double> calculateAverageRatingAllAuthors = authorRating.calculateAverageRatingAllAuthors();
        return calculateAverageRatingAllAuthors.entrySet()
                .stream()
                .map(entry -> {
                    AuthorRatingDto authorRatingDto = new AuthorRatingDto();
                    authorRatingDto.setAuthor(entry.getKey());
                    authorRatingDto.setAverageRating(entry.getValue());
                    return authorRatingDto;
                }).collect(Collectors.toList());
        }
}
