package com.amarszalek.Library.api.controllers;

import com.amarszalek.Library.AbstractTest;
import com.amarszalek.Library.domain.facades.AuthorRatingFacade;
import com.amarszalek.Library.infrastructure.dtos.AuthorRatingDto;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

public class AuthorsRatingsControllerTest extends AbstractTest {

    @MockBean
    private AuthorRatingFacade authorRatingFacade;
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private AuthorsRatingsController authorsRatingsController;

    @Test
    public void shouldReturnStatusOkWhenGettingAuthorsRatings() {
        //given
        List<AuthorRatingDto> authorRatingDtos = new ArrayList();
        when(authorRatingFacade.getAverageRatingAllAuthors()).thenReturn(authorRatingDtos);
        //when
        authorsRatingsController.getAuthorsRating();
        ResponseEntity<List> responseEntity = testRestTemplate.getForEntity(
                super.getBaseUrl() + "/api/rating", List.class);
        //then
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}