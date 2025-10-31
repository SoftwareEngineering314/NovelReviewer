package com.novelreviewer.io;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class JSONParser {
    public Map<String, List<Map<String, String>>> parseJSONFile(String path) throws IOException, ParseException {
        Map<String, List<Map<String, String>>> novels = new HashMap<>();

        try (FileReader reader = new FileReader(path)) {
            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            JSONObject root = (JSONObject) parser.parse(reader);

            for (Object keyObj : root.keySet()) {
                String novelName = (String) keyObj;
                JSONArray dataArray = (JSONArray) root.get(novelName);

                List<Map<String, String>> dataList = getDataList(dataArray);

                novels.put(novelName, dataList);
            }

        } catch (IOException | ParseException e) {
            throw e;
        }
        return novels;
    }

    private static List<Map<String, String>> getDataList(JSONArray dataArray) {
        List<Map<String, String>> dataList = new ArrayList<>();
        for (Object dataObj : dataArray) {
            JSONObject dataEntry = (JSONObject) dataObj;
            Map<String, String> map = new HashMap<>();
            for (Object fieldKey : dataEntry.keySet()) {
                String field = (String) fieldKey;
                String value = (String) dataEntry.get(field);
                map.put(field, value);
            }
            dataList.add(map);
        }
        return dataList;
    }

    public static void main(String[] args) {

    }
}