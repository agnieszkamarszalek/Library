package com.amarszalek.Library.infrastructure.utils.jsonParse.models;

import lombok.Data;

import java.util.Optional;

@Data
public class Item {
    private String id;
    private VolumeInfo volumeInfo;

    public String getISBN13() {
        Optional<IndustryIdentifier> isbn_13Optional = volumeInfo.getIndustryIdentifiers().stream()
                .filter(industryIdentifier -> industryIdentifier.getType().equals("ISBN_13"))
                .findFirst();
        if(isbn_13Optional.isPresent()) {
            return isbn_13Optional.get().getIdentifier();
        } else {
            return id;
        }
    }

}
