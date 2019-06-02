package com.amarszalek.Library.api.controllers;

import com.amarszalek.Library.AbstractTest;
import com.amarszalek.Library.domain.exceptions.BookNotFoundException;
import com.amarszalek.Library.domain.facades.BookFacade;
import com.amarszalek.Library.infrastructure.dtos.BookDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

public class BookControllerTest extends AbstractTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    @MockBean
    private BookFacade bookFacade;

    @Test
    public void shouldReturnStatusOkWhenGettingBookByIsbn() {
        //given
        when(bookFacade.getBookByIsbnOrId(any(String.class))).thenReturn(new BookDto());
        //when
        ResponseEntity<BookDto> responseEntity = testRestTemplate.getForEntity(
                super.getBaseUrl() + "/api/book/1", BookDto.class);
        //then
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void shouldReturnStatusNotFoundWhenGettingBookByIsbn() {
        //given
        doThrow(new BookNotFoundException("No results"))
                .when(bookFacade)
                .getBookByIsbnOrId(any(String.class));
        //when
        ResponseEntity<BookDto> responseEntity = testRestTemplate.getForEntity(super.getBaseUrl() + "/api/book/1", BookDto.class);
        //then
        Assert.assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }
}