package com.abf.main;

import com.abf.util.ParametersBFA;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainForm.fxml"));
        primaryStage.getIcons().add(new Image(getClass().getResource("/images/logo.png").toString()));
        primaryStage.setTitle(ParametersBFA.PROGRAM_NAME.getParamName());
        primaryStage.setScene(new Scene(root, 360, 376));
        primaryStage.setMinWidth(360);
        primaryStage.setMinHeight(378);
        Main.primaryStage = primaryStage;
        primaryStage.show();
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
