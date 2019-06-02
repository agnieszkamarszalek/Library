package com.amarszalek.Library.api.controllers;

import com.amarszalek.Library.AbstractTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class SearchControllerTest extends AbstractTest {

    @Test
    public void shouldReturnStatusOkWhenSearchingBookByPhrase() {
        //given
        when(super.bookFacade.findByPhrase(any(String.class))).thenReturn(new ArrayList<>());
        //when
        ResponseEntity<List> responseEntity = super.testRestTemplate.getForEntity(super.baseUrl + "/api/search?q=java", List.class);
        //then
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }


}