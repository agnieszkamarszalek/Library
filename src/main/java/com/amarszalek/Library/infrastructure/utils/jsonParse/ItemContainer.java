package com.amarszalek.Library.infrastructure.utils.jsonParse;

import lombok.Data;

import java.util.List;

@Data
public class ItemContainer {
    private String requestedUrl;
    private List<Item> items;
}
