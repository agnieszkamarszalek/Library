package com.amarszalek.Library.infrastructure.dtos;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import java.sql.Timestamp;
import java.util.List;

@Data
public class BookDto {

    private String isbn;
    private String title;
    private String subtitle;
    private String publisher;
    private Long publishedDate;
    private String description;
    private Integer pageCount;
    private String thumbnailUrl;
    private String language;
    private Double averageRating;
    private String previewLink;
    private List<String> authors;
    private List<String> categories;
}
