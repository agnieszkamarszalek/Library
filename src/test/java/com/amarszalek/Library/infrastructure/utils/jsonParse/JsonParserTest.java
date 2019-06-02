package com.amarszalek.Library.infrastructure.utils.jsonParse;

import com.amarszalek.Library.AbstractTest;
import com.amarszalek.Library.domain.models.Book;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;

public class JsonParserTest extends AbstractTest {
    @Autowired
    private JsonParser jsonParser;

    @Test
    public void shouldParseJson() {
        //given
        Book book = new Book();
        book.setId("-SYM4PW-YAgC");
        book.setIsbn("9780226285108");
        book.setCategories(Arrays.asList("Religion"));
        book.setAverageRating(4.0);
        book.setDescription("Written with a rare combination");
        //when
        List<Book> bookList = jsonParser.parseToBook();
        //then
        Assert.assertEquals(3, bookList.size());
        Assert.assertEquals(book.getId(), bookList.get(1).getId());
        Assert.assertEquals(book.getAverageRating(), bookList.get(1).getAverageRating());
        Assert.assertEquals(book.getDescription(), bookList.get(1).getDescription());
        Assert.assertEquals(book.getCategories(), bookList.get(1).getCategories());
        Assert.assertEquals(book.getIsbn(), bookList.get(1).getIsbn());
    }
}