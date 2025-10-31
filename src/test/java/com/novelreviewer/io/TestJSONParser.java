package com.novelreviewer.io;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestJSONParser {
    @Test
    public void testParseJSONFileThrows() {
        JSONParser parser = new JSONParser();
        assertThrows(IOException.class, () -> {parser.parseJSONFile("src/test/resources/testdat5.json");});
    }
    @Test
    public void testParseJSONFile() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Map<String, List<Map<String, String>>> novels = parser.parseJSONFile("src/test/resources/testdata1.json");

        // Example access
        for (String name : novels.keySet()) {
            System.out.println("Novel: " + name);
            for (Map<String, String> info : novels.get(name)) {
                for (String key : info.keySet()) {
                    System.out.println("  " + key + " : " + info.get(key));
                }
            }
        }
    }
}
