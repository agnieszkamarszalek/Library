package com.amarszalek.Library.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
public class Book {

    @Id
    private Long id;
    private String isbn;
    private String title;
    private String subtitle;
    private String publisher;
    private Timestamp publishedDate;
    private String description;
    private int pageCount;
    private String thumbnailUrl;
    private String language;
    private double averageRating;
    @ElementCollection
    private List<String> authors;
    @ElementCollection
    private List<String> categories;
}
