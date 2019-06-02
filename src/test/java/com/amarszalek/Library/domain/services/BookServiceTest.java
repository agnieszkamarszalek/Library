package com.amarszalek.Library.domain.services;

import com.amarszalek.Library.AbstractTest;
import com.amarszalek.Library.domain.models.Book;
import com.amarszalek.Library.domain.repositories.BookRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class BookServiceTest extends AbstractTest {
    @Autowired
    private BookService bookService;
    private List<Book> bookList = new ArrayList<>();
    @MockBean
    private BookRepository bookRepository;

    @Before
    public void setUp() {
        for (int i = 0; i < 3; i++) {
            bookList.add(new Book());
        }
    }

    @Test
    public void shouldReturnBookListWithSearchingPhraseInTitle() {
        //given
        String lookingPhrase = "jav";
        bookList.get(0).setTitle("Java programming");
        bookList.get(1).setTitle("Everything about biology");
        bookList.get(2).setTitle("Nojavo");
        when(bookRepository.findAll()).thenReturn(bookList);
        //when
        List<Book> booksByPhrase = bookService.getBooksByPhrase(lookingPhrase);
        //then
        Assert.assertEquals(2, booksByPhrase.size());
    }

    @Test
    public void shouldReturnBookListWithSearchingPhraseInAuthors() {
        //given
        String lookingPhrase = "Adam";
        bookList.get(0).setAuthors(Arrays.asList("Adam Piatkowski"));
        bookList.get(1).setAuthors(Arrays.asList("Karol Wesolek"));
        bookList.get(2).setAuthors(Arrays.asList("Karol Adamowicz"));
        when(bookRepository.findAll()).thenReturn(bookList);
        //when
        List<Book> booksByPhrase = bookService.getBooksByPhrase(lookingPhrase);
        //then
        Assert.assertEquals(2, booksByPhrase.size());

    }

    @Test
    public void shouldReturnBookListWitSearchingPhraseInDescription() {
        //given
        String lookingPhrase = "look";
        bookList.get(0).setDescription("Java programming");
        bookList.get(1).setDescription("Looking for adventure");
        bookList.get(2).setDescription("How look back");
        when(bookRepository.findAll()).thenReturn(bookList);
        //when
        List<Book> booksByPhrase = bookService.getBooksByPhrase(lookingPhrase);
        //then
        Assert.assertEquals(2, booksByPhrase.size());
    }

    @Test
    public void shouldReturnBookListWitSearchingPhraseInCategories() {
        //given
        String lookingPhrase = "program";
        bookList.get(0).setCategories(Arrays.asList("Programming", "Life"));
        bookList.get(1).setCategories(Arrays.asList("Life"));
        when(bookRepository.findAll()).thenReturn(bookList);
        //when
        List<Book> booksByPhrase = bookService.getBooksByPhrase(lookingPhrase);
        //then
        Assert.assertEquals(1, booksByPhrase.size());

    }

    @Test
    public void shouldReturnBookListWithSearchingPhraseWithUniqueElements() {
        //given
        String lookingPhrase = "java";
        bookList.get(0).setTitle("Java programming");
        bookList.get(0).setDescription("Everything about java programming");
        bookList.get(0).setAuthors(Arrays.asList("Java Developer"));
        when(bookRepository.findAll()).thenReturn(bookList);
        //when
        List<Book> booksByPhrase = bookService.getBooksByPhrase(lookingPhrase);
        //then
        Assert.assertEquals(1, booksByPhrase.size());

    }

}