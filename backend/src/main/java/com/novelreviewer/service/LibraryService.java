package com.novelreviewer.service;

import com.novelreviewer.model.Library;
import com.novelreviewer.model.Novel;
import com.novelreviewer.utility.FileStorage;

import java.io.IOException;

public class LibraryService {
    private final Library library = new Library();
    private final FileStorage storage = new FileStorage();

    public void addNovel(String title, String author, int chapters, double rating) {
        Novel novel = new Novel(title, author, chapters, rating);
        library.addNovel(title, novel);
    }
    public Library getLibrary(){
        return library;
    }
    public void loadLibrary() throws IOException {
        Library loadedLibrary = storage.loadLibrary();
        library.clear();
        library.getNovels().putAll(loadedLibrary.getNovels());
    }
    public void saveLibrary() throws IOException {
        storage.saveLibrary(library);
    }
}
