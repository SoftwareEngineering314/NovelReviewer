package com.novelreviewer.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import com.gluonhq.charm.glisten.visual.Theme;
public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 200);
        Theme theme = Theme.DARK;
        theme.assignTo(scene);
        stage.setTitle("Novel Reviewer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
