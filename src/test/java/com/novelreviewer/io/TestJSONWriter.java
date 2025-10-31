package com.novelreviewer.io;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestJSONWriter {
    @Test
    public void testJSONWriter() throws IOException, ParseException {
        JSONWriter jsonWriter = new JSONWriter();
        JSONParser jsonParser = new JSONParser();
        jsonWriter.writeJSON(jsonParser.parseJSONFile("src/test/resources/testdata1.json"), "src/test/resources/testoutput1.json");

    }
    public static void main(String[] args) throws IOException, ParseException {
        TestJSONWriter JSONWriter = new TestJSONWriter();
        JSONWriter.testJSONWriter();

    }
}
