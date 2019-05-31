package com.amarszalek.Library.infrastructure.utils.jsonParse;

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
    private int pageCount;
    private ImageLinks imageLinks;
    private String langugage;
    private String previewLink;
    private double averageRating;
    private List<String> authors;
    private List<String> categories;
}