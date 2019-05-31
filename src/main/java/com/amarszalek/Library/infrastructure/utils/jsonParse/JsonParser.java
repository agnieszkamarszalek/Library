package com.amarszalek.Library.infrastructure.utils.jsonParse;

import com.amarszalek.Library.domain.models.Book;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JsonParser {

    public void parseToBook() {
        // read json
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/books.json");
        ItemContainer itemContainer = new ItemContainer();
        List<Book> bookList = new ArrayList<>();
        try {
            itemContainer = mapper.readValue(inputStream,ItemContainer.class);
            bookList = convertItemContainerIntoBook(itemContainer);
            System.out.println("Json read");
        } catch (IOException e){
            System.out.println("Couldn't read json" + e.getMessage());
        }
    }

    private List<Book> convertItemContainerIntoBook(ItemContainer itemContainer) {
        List<Item> items = itemContainer.getItems();
        return items.stream().map(
                item -> {
                    Book book = new Book();
                    book.setSubtitle(item.getVolumeInfo().getSubtitle());
                    book.setPublisher(item.getVolumeInfo().getPublisher());
                    book.setPublishedDate(item.getVolumeInfo().getPublishedDate());
                    book.setDescription(item.getVolumeInfo().getDescription());
                    book.setPageCount(item.getVolumeInfo().getPageCount());
                    book.setIsbn(item.getISBN13());
                    book.setTitle(item.getVolumeInfo().getTitle());
                    book.setThumbnailUrl(item.getVolumeInfo().getImageLinks().getThumbnail());
                    book.setLanguage(item.getVolumeInfo().getLanguage());
                    book.setAuthors(item.getVolumeInfo().getAuthors());
                    book.setCategories(item.getVolumeInfo().getCategories());
                    return book;
                }
        )
                .collect(Collectors.toList());
    }
}
