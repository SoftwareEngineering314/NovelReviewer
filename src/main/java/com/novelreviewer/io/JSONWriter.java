package com.novelreviewer.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.novelreviewer.model.Library;
import com.novelreviewer.model.Novel;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class JSONWriter {

    public void writeJSON(Library library, String filepath) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(filepath)) {

            Map<String, Novel> novels = library.getNovels();
            gson.toJson(novels, writer);
        }
    }
}
