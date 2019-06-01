package com.amarszalek.Library.infrastructure.utils;

import com.amarszalek.Library.domain.models.Book;
import com.amarszalek.Library.infrastructure.utils.jsonParse.JsonParser;
import com.amarszalek.Library.infrastructure.utils.saveToDatabase.SaveToDatabase;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class JsonParseAndSaveToDatabase {

    private JsonParser jsonParser;
    private SaveToDatabase saveToDatabase;

    public void parseAndSave() {
        List<Book> books = jsonParser.parseToBook();
        saveToDatabase.saveBooks(books);
    }
}
