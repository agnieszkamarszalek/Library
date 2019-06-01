package com.amarszalek.Library.infrastructure.utils.jsonParse.models;

import com.amarszalek.Library.infrastructure.utils.jsonParse.models.ImageLinks;
import com.amarszalek.Library.infrastructure.utils.jsonParse.models.IndustryIdentifier;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class VolumeInfo {
    private List<IndustryIdentifier> industryIdentifiers;
    private String title;
    private String subtitle;
    private String publisher;
    private Timestamp publishedDate; // "2006", "2013-12-09"
    private String description;
    private Integer pageCount;
    private ImageLinks imageLinks;
    private String language;
    private String previewLink;
    private Double averageRating;
    private List<String> authors;
    private List<String> categories;

}