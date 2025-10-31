package com.novelreviewer.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private static Map<String, List<Map<String, String>>> novels = new HashMap<>();

    public void addNovel(String title, String rating, String num_chapters, String author) {
        Map<String, String> info = new HashMap<>();
        info.put("Chapters", num_chapters);
        info.put("Rating", rating);
        info.put("Author", author);
        List<Map<String, String>> data = new ArrayList<>();
        data.add(info);
        novels.put(title, data);
    }
    public void removeNovel(String title){
        novels.remove(title);
    }
    public static void loadNovels(Map<String, List<Map<String, String>>> loadedNovels) {
        novels.clear();
        novels.putAll(loadedNovels);
    }
    public static  List<Map<String, String>> getNovel(String title) {
        return novels.get(title);
    }
    public static Map<String, List<Map<String, String>>> getNovels() {
        return novels;
    }

}
