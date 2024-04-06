package org.example.runforlife_app.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class Controller {

    protected Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
        Initialize();
    }

    public abstract void Initialize();

    public Controller changeScene(FXMLLoader fxmlLoader, Stage stage) {
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Controller controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.setScene(scene);
        stage.setMaximized(false);
        stage.setMaximized(true);
        return controller;
    }


}
