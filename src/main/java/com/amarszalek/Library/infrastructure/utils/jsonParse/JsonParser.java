package com.amarszalek.Library.infrastructure.utils.jsonParse;

import com.amarszalek.Library.domain.models.Book;
import com.amarszalek.Library.infrastructure.utils.jsonParse.models.Item;
import com.amarszalek.Library.infrastructure.utils.jsonParse.models.ItemContainer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JsonParser {

    @Value("${jsonPath}")
    private String jsonPath;

    public List<Book> parseToBook() {
        // read json
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        InputStream inputStream = TypeReference.class.getResourceAsStream(jsonPath);
        ItemContainer itemContainer;
        List<Book> bookList = new ArrayList<>();
        try {
            itemContainer = mapper.readValue(inputStream,ItemContainer.class);
            bookList = convertItemContainerIntoBook(itemContainer);
        } catch (IOException e){
            System.out.println("Couldn't read json" + e.getMessage());
        }
        return bookList;
    }

    private List<Book> convertItemContainerIntoBook(ItemContainer itemContainer) {
        List<Item> items = itemContainer.getItems();
        return items.stream()
                .filter(book -> book.getVolumeInfo() != null)
                .map(
                item -> {
                    Book book = new Book();
                    book.setId(item.getId());
                    book.setSubtitle(item.getVolumeInfo().getSubtitle());
                    book.setPublisher(item.getVolumeInfo().getPublisher());
                    book.setPublishedDate(item.getVolumeInfo().getPublishedDate());
                    book.setDescription(item.getVolumeInfo().getDescription());
                    book.setPageCount(item.getVolumeInfo().getPageCount());
                    book.setIsbn(item.getISBN13());
                    book.setTitle(item.getVolumeInfo().getTitle());
                    book.setThumbnailUrl(item.getVolumeInfo().getImageLinks().getThumbnail());
                    book.setLanguage(item.getVolumeInfo().getLanguage());
                    book.setAverageRating(item.getVolumeInfo().getAverageRating());
                    book.setPreviewLink(item.getVolumeInfo().getPreviewLink());
                    book.setAuthors(item.getVolumeInfo().getAuthors());
                    book.setCategories(item.getVolumeInfo().getCategories());
                    return book;
                }
        )
                .collect(Collectors.toList());
    }
}
