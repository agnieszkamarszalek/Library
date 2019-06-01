package com.amarszalek.Library.infrastructure.dtos;

import lombok.Data;

@Data
public class AuthorRatingDto {

    private String author;
    private Double averageRating;
}
