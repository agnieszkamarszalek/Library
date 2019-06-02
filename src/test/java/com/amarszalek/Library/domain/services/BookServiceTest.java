package com.amarszalek.Library.domain.services;

import com.amarszalek.Library.AbstractTest;
import com.amarszalek.Library.domain.exceptions.BookNotFoundException;
import com.amarszalek.Library.domain.models.Book;
import com.amarszalek.Library.domain.repositories.BookRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.*;
import static org.mockito.ArgumentMatchers.any;
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

    @Test
    public void shouldReturnMapWithAuthorsAndTheirsBooksRatings() {
        //given
        bookList.get(0).setAuthors(Arrays.asList("Authors"));
        bookList.get(0).setAverageRating(4.0);
        bookList.get(1).setAuthors(Arrays.asList("Authors", "Chris"));
        bookList.get(1).setAverageRating(2.0);
        bookList.get(2).setAuthors(Arrays.asList("Krzysztof"));
        when(bookRepository.findAll()).thenReturn(bookList);
        //when
        Map<String, List<Double>> authorsWithTheirsBooksRatings = bookService.getAuthorsWithTheirsBooksRatings();
        //then
        Assert.assertTrue(authorsWithTheirsBooksRatings.containsKey("Authors"));
        Assert.assertTrue(authorsWithTheirsBooksRatings.containsKey("Chris"));
        Assert.assertEquals(authorsWithTheirsBooksRatings.get("Authors"), Arrays.asList(4.0, 2.0));
        Assert.assertEquals(authorsWithTheirsBooksRatings.get("Chris"), Arrays.asList(2.0));
    }

    @Test
    public void shouldReturnEmptyListWhenGettingBooksByCategory() {
        //given
        Optional<List<Book>> optional = Optional.empty();
        when(bookRepository.findByCategoriesIgnoreCase(any(String.class))).thenReturn(optional);
        //when
        List<Book> books = bookService.getBooksByCategory("Programming");
        //then
        Assert.assertEquals(0,books.size());
    }

    @Test(expected = BookNotFoundException.class)
    public void shouldThrowExceptionWhenSearchingByIsbn() {
        //given
        Optional<List<Book>> optional = Optional.empty();
        when(bookRepository.findByCategoriesIgnoreCase(any(String.class))).thenReturn(optional);
        //when
        bookService.findByIsbn("isbn");
    }

}