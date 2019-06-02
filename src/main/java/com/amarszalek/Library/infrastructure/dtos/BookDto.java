package com.amarszalek.Library.infrastructure.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
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
