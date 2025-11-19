package com.novelreviewer.ui;
import com.novelreviewer.service.LibraryService;
import com.novelreviewer.utility.FileStorage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.IOException;


public class MainController {
    private final LibraryService libraryService = new LibraryService();
    private final FileStorage storage = new FileStorage();
    @FXML
    private Label label;
    @FXML
    private TextField authorInput;
    @FXML
    private TextField titleInput;
    @FXML
    private TextField chapterInput;
    @FXML
    private TextField ratingInput;
    @FXML
    private Button novelAddButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button loadButton;
    @FXML
    private void handleAddNovel(ActionEvent event) {
        libraryService.addNovel(authorInput.getText(), titleInput.getText(), chapterInput.getText(), ratingInput.getText());
        authorInput.clear();
        titleInput.clear();
        ratingInput.clear();
        chapterInput.clear();
    }
    @FXML
    private void saveLibrary(ActionEvent event) {
        try {
            storage.saveLibrary(libraryService.getLibrary(), "userdata/novels/novels.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void loadLibrary(ActionEvent event) {
        try{
            libraryService.loadLibrary();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void handleClick() {
        label.setText("You clicked the button!");
    }
}
