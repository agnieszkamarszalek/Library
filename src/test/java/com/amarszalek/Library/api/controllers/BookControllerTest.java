package com.amarszalek.Library.api.controllers;

import com.amarszalek.Library.AbstractTest;
import com.amarszalek.Library.domain.exceptions.BookNotFoundException;
import com.amarszalek.Library.infrastructure.dtos.BookDto;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

public class BookControllerTest extends AbstractTest {

    @Test
    public void shouldReturnStatusOkWhenGettingBookByIsbn() {
        //given
        when(super.bookFacade.getBookByIsbnOrId(any(String.class))).thenReturn(new BookDto());
        //when
        ResponseEntity<BookDto> responseEntity = super.testRestTemplate.getForEntity(
                super.baseUrl + "/api/book/1", BookDto.class);
        //then
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void shouldReturnStatusNotFoundWhenGettingBookByIsbn() {
        //given
        doThrow(new BookNotFoundException("No results"))
                .when(super.bookFacade)
                .getBookByIsbnOrId(any(String.class));
        //when
        ResponseEntity<BookDto> responseEntity = super.testRestTemplate.getForEntity(super.baseUrl + "/api/book/1", BookDto.class);
        //then
        Assert.assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }
}