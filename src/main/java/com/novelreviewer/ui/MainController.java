package com.novelreviewer.ui;

import com.novelreviewer.model.Library;
import com.novelreviewer.model.Novel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

public class MainController {
    private String author;
    private String title;
    private String chapters;
    private String rating;
    private final Library library = new Library();
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
    private void handleAddNovel(ActionEvent event) {
        String author = authorInput.getText();
        String title = titleInput.getText();
        String rating = ratingInput.getText();
        String chapters = chapterInput.getText();
        Novel novel = new Novel(author, rating, chapters);
        Library library = new Library();
        library.addNovel(title, novel);
        authorInput.clear();
        titleInput.clear();
        ratingInput.clear();
        chapterInput.clear();
    }

    @FXML
    private void handleClick() {
        label.setText("You clicked the button!");
    }
}
