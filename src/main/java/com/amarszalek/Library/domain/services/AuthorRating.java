package com.amarszalek.Library.domain.services;

import lombok.AllArgsConstructor;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AuthorRating {

    private BookService bookService;

    public Map<String, Double> calculateAverageRatingAllAuthors() {
        Map<String, List<Double>> authorsWithTheirsBooksRatings = bookService.getAuthorsWithTheirsBooksRatings();
        Map<String, Double> authorsWithTheirsAverageRatings = new HashMap<>();
        for (Map.Entry<String, List<Double>> entry : authorsWithTheirsBooksRatings.entrySet()) {
            Double averageRating = entry.getValue().stream()
                    .reduce(Double::sum).get();
            authorsWithTheirsAverageRatings.put(entry.getKey(), averageRating);
        }
        return authorsWithTheirsAverageRatings
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(
                        Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)
                );
    }
}
