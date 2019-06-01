package com.amarszalek.Library.infrastructure.utils.jsonParse.models;

import com.amarszalek.Library.infrastructure.utils.jsonParse.models.Item;
import lombok.Data;

import java.util.List;

@Data
public class ItemContainer {
    private List<Item> items;
}
