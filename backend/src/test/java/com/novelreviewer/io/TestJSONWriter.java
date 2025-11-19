package com.novelreviewer.io;

import com.novelreviewer.model.Library;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestJSONWriter {

    @Test
    public void testJSONWriter() throws IOException {
        // Arrange: prepare parser and writer
        JSONWriter jsonWriter = new JSONWriter();
        JSONParser jsonParser = new JSONParser();

        // Act: read input and write to output
        Library library = jsonParser.parseJSONFile("src/test/resources/testdata1.json");
        jsonWriter.writeJSON(library, "src/test/resources/testoutput1.json");

        // Assert: verify output file exists and isn’t empty
        assertNotNull(library);
        assertTrue(Files.exists(Paths.get("src/test/resources/testoutput1.json")),
                "Output file should exist");
        assertTrue(Files.size(Paths.get("src/test/resources/testoutput1.json")) > 0,
                "Output file should not be empty");

        System.out.println("JSON writing successful! File created at: src/test/resources/testoutput1.json");
    }

    // Optional standalone run for manual testing
    public static void main(String[] args) {
        try {
            TestJSONWriter tester = new TestJSONWriter();
            tester.testJSONWriter();
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
}
