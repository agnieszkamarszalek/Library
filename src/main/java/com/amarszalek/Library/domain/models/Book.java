package com.amarszalek.Library.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.Entity;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
public class Book {

    private String isbn;
    private String title;
    private String subtitle;
    private String publisher;
    private long publishedDate;
    private String description;
    private int pageCount;
    private String thumbnailUrl;
    private String language;
    private double averageRating;
    private List<String> authors;
    private List<String> categories;
}
