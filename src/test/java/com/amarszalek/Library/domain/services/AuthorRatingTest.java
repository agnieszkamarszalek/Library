package com.amarszalek.Library.domain.services;

import com.amarszalek.Library.AbstractTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class AuthorRatingTest extends AbstractTest {
    @MockBean
    private BookService bookService;
    @Autowired
    private AuthorRating authorRating;

    @Test
    public void shouldCalculateAverageAuthorsBooksRating() {
        //given
        HashMap<String, List<Double>> map = new HashMap<>();
        map.put("Krasinski", Arrays.asList(2.0,3.0,4.0));
        map.put("Mickiewicz", Arrays.asList(2.0,3.0,4.0, 5.0));
        when(bookService.getAuthorsWithTheirsBooksRatings()).thenReturn(map);
        //when
        Map<String, Double> result = authorRating.calculateAverageRatingAllAuthors();
        //then
        Assert.assertEquals((Double) 3.0, result.get("Krasinski"));
        Assert.assertEquals((Double) 3.5, result.get("Mickiewicz"));

    }

}