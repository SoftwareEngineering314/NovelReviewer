package com.novelreviewer.utility;

import com.novelreviewer.io.JSONParser;
import com.novelreviewer.io.JSONWriter;
import com.novelreviewer.model.Library;

import java.io.IOException;

public class FileStorage {
    private final JSONWriter jsonWriter = new JSONWriter();
    private final JSONParser reader = new JSONParser();

    private String filepath;
    private String backupFilepath;

    public FileStorage(){
        this.filepath = "backend/userdata/novels/novels.json";
        this.backupFilepath = "backend/userdata/backup";
    }

    public FileStorage(String filepath, String backupFilepath){
        this.filepath = filepath;
        this.backupFilepath = backupFilepath;
    }

    public void saveLibrary(Library library, String filepath) throws IOException {
        jsonWriter.writeJSON(library, filepath);
    }
    public void saveLibrary(Library library) throws IOException {
        saveLibrary(library, filepath);
    }
    public Library loadLibrary() throws IOException {
        return reader.parseJSONFile(filepath);
    }
    public void backupLibrary(Library library) throws IOException {
        saveLibrary(library, backupFilepath);
    }
    public void setFilepath(String filepath){
        this.filepath = filepath;
    }
    public void setBackupFilepath(String filepath) {
        this.backupFilepath = filepath;
    }
    public String getFilepath() {
        return filepath;
    }
    public String getBackupFilepath(){
        return backupFilepath;
    }
}
