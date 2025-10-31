package com.novelreviewer.io;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class JSONWriter {
    public void writeJSON(Map<String, List<Map<String, String>>> novels, String filepath) throws FileNotFoundException {
        JSONObject jsonObject = new JSONObject();
        for(Map.Entry<String, List<Map<String, String>>> entry : novels.entrySet()){
            String novelname = entry.getKey();
            List<Map<String, String>> values = entry.getValue();
            jsonObject.put(novelname, values);
        }
        try {
            PrintWriter writer = new PrintWriter(filepath);
            writer.write(jsonObject.toJSONString());
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            throw new RuntimeException(e);
        }
    }
}
