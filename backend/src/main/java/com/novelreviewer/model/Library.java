package com.novelreviewer.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<String, Novel> novels = new HashMap<>();

    public void addNovel(String title, String json) {
        this.novels.put(title, Novel.fromJson(json));
    }
    public void addNovel(String title, Novel novel){
        this.novels.put(title, novel);
    }

    public Novel getNovel(String title) {
        return this.novels.get(title);
    }

    public Novel removeNovel(String title) {
        return novels.remove(title);
    }

    public void clear() {
        novels.clear();
    }

    public Map<String, Novel> getNovels() {
        return novels;
    }

    public List<Novel> getNovelList() {
        return new ArrayList<>(novels.values());
    }

    public void setNovelsAsList(List<Novel> list) {
        novels.clear();
        for (Novel n : list) {
            novels.put(n.getTitle(), n);
        }
    }
}
