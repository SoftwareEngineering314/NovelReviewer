package com.novelreviewer.io;

import com.novelreviewer.model.Library;
import com.novelreviewer.model.Novel;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestJSONParser {

    @Test
    public void testParseJSONFileThrows() {
        JSONParser parser = new JSONParser();

        // Should throw IOException for a missing file
        assertThrows(IOException.class, () -> {
            parser.parseJSONFile("src/test/resources/nonexistent.json");
        });
    }

    @Test
    public void testParseJSONFile() throws IOException {
        JSONParser parser = new JSONParser();
        Library library = parser.parseJSONFile("backend/src/test/resources/testdata1.json");

        // Ensure something was parsed
        assertNotNull(library);
        assertFalse(library.getNovels().isEmpty(), "Library should contain novels");

        // Example access: print for debugging
        for (String title : library.getNovels().keySet()) {
            Novel novel = library.getNovel(title);
            System.out.println("Novel: " + title);
            System.out.println("  Author : " + novel.getAuthor());
            System.out.println("  Rating  : " + novel.getRating());
            System.out.println("  Chapters: " + novel.getChapters());
        }

    }
}
