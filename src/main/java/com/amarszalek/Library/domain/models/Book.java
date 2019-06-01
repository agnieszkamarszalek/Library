package com.amarszalek.Library.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String title;
    private String subtitle;
    private String publisher;
    private Timestamp publishedDate;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Integer pageCount;
    private String thumbnailUrl;
    private String language;
    private Double averageRating;
    private String previewLink;
    @ElementCollection
    private List<String> authors;
    @ElementCollection
    private List<String> categories;
}
