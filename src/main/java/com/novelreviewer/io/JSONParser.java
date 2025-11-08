package com.novelreviewer.io;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.novelreviewer.model.Library;
import com.novelreviewer.model.Novel;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

public class JSONParser {

    public Library parseJSONFile(String path) throws IOException {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Novel>>() {}.getType();

        try (FileReader reader = new FileReader(path)) {
            Map<String, Novel> novelMap = gson.fromJson(reader, type);
            Library library = new Library();
            library.getNovels().putAll(novelMap);
            return library;
        }
    }
}
